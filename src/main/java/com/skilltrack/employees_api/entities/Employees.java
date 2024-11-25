package com.skilltrack.employees_api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Employees")
@Getter
@Setter
public class Employees {

    public Employees() {}

    @Id
    @Column(name = "id_employees")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEmployess;

    @Column(name = "name")
    String name;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "contact", unique = true, nullable = false)
    String contact;

    @Column(name = "hardskills")
    String hardSkills;

    @Column(name = "certifications")
    String certifications;

    @Column(name = "time_of_experience")
    String timeOfExperience;

    @Column(name = "user_linkedin")
    String userLinkedin;
}
