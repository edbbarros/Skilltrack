package com.skilltrack.employees_api.services;

import com.skilltrack.employees_api.entities.Employees;
import com.skilltrack.employees_api.exceptions.NotFoundException;
import com.skilltrack.employees_api.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Método para listar todos os funcionários
    public List<Employees> getAllEmployees() { return employeeRepository.findAll(); }

    // Método para buscar os colaboradores por Id
    public Employees getEmployeeById(long id) throws NotFoundException {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
    }

    // Metodo para buscar colaboradores por nome, email, linkedin e contato
    public List<Employees> searchEmployees(String value) {
        return employeeRepository.searchByAllFields(value);
    }

    // Método para salvar ou atualizar um funcionário
    public Employees saveOrUpdateEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    // Método para deletar um funcionário
    public void deleteEmployee(long id) throws NotFoundException {
        try {
            var employee = getEmployeeById(id);
        } catch (NotFoundException err) {
            throw new NotFoundException("Funcionario não encontrado");
        }

        employeeRepository.deleteById(id);
    }
}
