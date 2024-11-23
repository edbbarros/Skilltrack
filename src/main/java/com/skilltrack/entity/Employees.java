package com.skilltrack.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employees {
    public Employees() {

    }

    @Id
    Long id_employees;
    String name;
    String email;
    String contact;
    String hardskills;
    String certifications;
    String time_of_experience;
    String user_linkedin;


    public Long getId_employees() {
        return id_employees;
    }

    public void setId_employees(int id_employees) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
    }

    public String getHardskills() {
        return hardskills;
    }

    public void setHardskills(String hardskills) {
        this.hardskills = hardskills;

    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
    }

    public String getTime_of_experience() {
        return time_of_experience;
    }

    public void setTime_of_experience(String time_of_experience) {
        this.time_of_experience = time_of_experience;
    }

    public String getUser_linkedin() {
        return user_linkedin;
    }

    public void setUser_linkedin(String user_linkedin) {
    }
}
