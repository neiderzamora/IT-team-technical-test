package com.ITteam.technicaltest.dto;

import java.time.LocalDate;

public class EmployeeWithDetailsDTO {
    private Long id;
    private String name;
    private String email;
    private String position;
    private Double salary;
    private LocalDate hireDate;
    private String departmentName;
    private String roleName;

    // Constructor, getters y setters
    public EmployeeWithDetailsDTO(Long id, String name, String email, String position, Double salary, LocalDate hireDate, String departmentName, String roleName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}