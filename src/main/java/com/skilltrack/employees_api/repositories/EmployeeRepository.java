package com.skilltrack.employees_api.repositories;

import com.skilltrack.employees_api.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
    Employees findEmployeesByEmail(String email);

    @Query("SELECT e FROM Employees e" +
            "   WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :value, '%'))" +
            "   OR LOWER(e.contact) LIKE LOWER(CONCAT('%', :value, '%'))" +
            "   OR LOWER(e.userLinkedin) LIKE LOWER(CONCAT('%', :value, '%'))" +
            "   OR LOWER(e.email) LIKE LOWER(CONCAT('%', :value, '%'))")
    List<Employees> searchByAllFields(@Param("value") String value);
}
