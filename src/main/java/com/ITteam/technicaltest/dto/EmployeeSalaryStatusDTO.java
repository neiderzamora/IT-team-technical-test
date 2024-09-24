package com.ITteam.technicaltest.dto;

import java.time.LocalDate;

public class EmployeeSalaryStatusDTO {
    private Long id;
    private String name;
    private String email;
    private String position;
    private Double salary;
    private LocalDate hireDate;
    private String departmentName;
    private String salaryStatus;

    // Constructor, getters y setters
    public EmployeeSalaryStatusDTO(Long id, String name, String email, String position, Double salary, LocalDate hireDate, String departmentName, String salaryStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentName = departmentName;
        this.salaryStatus = salaryStatus;
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

    public String getSalaryStatus() {
        return salaryStatus;
    }

    public void setSalaryStatus(String salaryStatus) {
        this.salaryStatus = salaryStatus;
    }
}