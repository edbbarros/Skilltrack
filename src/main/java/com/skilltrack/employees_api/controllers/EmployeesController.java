package com.skilltrack.employees_api.controllers;

import com.skilltrack.employees_api.entities.Employees;
import com.skilltrack.employees_api.exceptions.NotFoundException;
import com.skilltrack.employees_api.services.EmployeeService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        var employees = employeeService.getAllEmployees();
        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchEmployees(@RequestParam String query) {
        var employees = employeeService.searchEmployees(query);

        if (employees.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
        }

        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getEmployee(@PathVariable long id) {
        try {
            var employee = employeeService.getEmployeeById(id);

            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (NotFoundException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado!");
        }
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employees employees) {
        try {
            employeeService.saveOrUpdateEmployee(employees);
        } catch (DataIntegrityViolationException err) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("já existe um colaborador cadastrado com os dados");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Colaborador adicionado com sucesso");
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable long id,@RequestBody Employees employees) {
        try {
            var employee = employeeService.getEmployeeById(id);

            if (!employee.equals(employees)) {
                employee = employees;
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
            }

            employeeService.saveOrUpdateEmployee(employee);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Colaborador atualizado com sucesso!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable long id) throws NotFoundException {

        try {
            employeeService.deleteEmployee(id);

            return ResponseEntity.status(HttpStatus.OK).body("Colaborador apagado");
        } catch (NotFoundException err) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Colaborador nao econtrado");
        }



    }
}
