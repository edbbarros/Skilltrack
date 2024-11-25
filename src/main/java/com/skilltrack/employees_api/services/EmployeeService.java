package com.skilltrack.employees_api.services;

import com.skilltrack.employees_api.entities.Employees;
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
    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Método para buscar os colaboradores por Id
    public Optional<Employees> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }

    // Método para salvar ou atualizar um funcionário
    public Employees saveOrUpdateEmployee(Employees employee) {
        return employeeRepository.save(employee);
    }

    // Método para deletar um funcionário
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
