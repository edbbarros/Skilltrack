package com.skilltrack.service;

import com.skilltrack.entity.Employees;
import com.skilltrack.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    //Metodo para listar todos os funcionários
    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }
    //Metodo para buscar os colaboradores por ID
    public Optional<Employees> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }
    // Método para salvar ou atualizar um funcionário
    public Employees saveOrUpdateEmployee(Employees employee) {
        return (Employees) employeeRepository.save(employee);
    }
    // Método para deletar um funcionário
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

}
