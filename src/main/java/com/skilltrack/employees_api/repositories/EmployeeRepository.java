package com.skilltrack.employees_api.repositories;

import com.skilltrack.employees_api.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {

}
