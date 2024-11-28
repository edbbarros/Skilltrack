package com.skilltrack.employees_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity(name = "Employees")
@Getter
@Setter
public class Employees {

    public Employees() {}

    @Id
    @Column(name = "id_employees")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmployee;

    @Column(name = "name", nullable = false, length = 150)
    String name;

    @Column(name = "email", unique = true, nullable = false, length = 300)
    String email;

    @Column(name = "contact", unique = true, nullable = false, length = 15)
    String contact;

    @Column(name = "hardskills")
    String hardSkills;

    @Column(name = "certifications")
    String certifications;

    @Column(name = "time_of_experience")
    String timeOfExperience;

    @Column(name = "user_linkedin")
    String userLinkedin;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Employees that = (Employees) obj;

        // Comparação dos campos relevantes
        return idEmployee == that.idEmployee
                && Objects.equals(name, that.name)
                && Objects.equals(email, that.email)
                && Objects.equals(contact, that.contact)
                && Objects.equals(hardSkills, that.hardSkills)
                && Objects.equals(certifications, that.certifications)
                && Objects.equals(timeOfExperience, that.timeOfExperience)
                && Objects.equals(userLinkedin, that.userLinkedin);
    }
}
