package com.skilltrack.employees_api.controllers;

import com.skilltrack.employees_api.entities.Employees;
import com.skilltrack.employees_api.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String test() {
        return "test";
    }

    @PostMapping
    public Employees createEmployee(@RequestBody Employees employees) {
        return employeeService.saveOrUpdateEmployee(employees);

    }
}
