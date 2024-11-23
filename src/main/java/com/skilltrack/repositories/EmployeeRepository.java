
package com.skilltrack.repositories;

import com.skilltrack.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EmployeeRepository<Employees, Long> extends JpaRepository<Employees, Long> {
}
