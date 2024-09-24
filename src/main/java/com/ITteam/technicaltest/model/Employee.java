package com.ITteam.technicaltest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "name can only contain letters and spaces")
    @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "email cannot be empty")
    @Email(message = "type a valid email")
    private String email;

    @NotBlank(message = "position cannot be empty")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "position can only contain letters and spaces")
    private String position;

    @NotNull(message = "salary cannot be null")
    @Positive(message = "salary must be greater than zero")
    private Double salary;

    @NotNull(message = "hire date cannot be null")
    @PastOrPresent(message = "hire date cannot be in the future")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate hireDate;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "name cannot be empty") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "name can only contain letters and spaces") @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "name cannot be empty") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "name can only contain letters and spaces") @Size(min = 2, max = 50, message = "name must be between 2 and 50 characters") String name) {
        this.name = name;
    }

    public @NotBlank(message = "email cannot be empty") @Email(message = "type a valid email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email cannot be empty") @Email(message = "type a valid email") String email) {
        this.email = email;
    }

    public @NotBlank(message = "position cannot be empty") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "position can only contain letters and spaces") String getPosition() {
        return position;
    }

    public void setPosition(@NotBlank(message = "position cannot be empty") @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "position can only contain letters and spaces") String position) {
        this.position = position;
    }

    public @NotNull(message = "salary cannot be null") @Positive(message = "salary must be greater than zero") Double getSalary() {
        return salary;
    }

    public void setSalary(@NotNull(message = "salary cannot be null") @Positive(message = "salary must be greater than zero") Double salary) {
        this.salary = salary;
    }

    public @NotNull(message = "hire date cannot be null") @PastOrPresent(message = "hire date cannot be in the future") LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(@NotNull(message = "hire date cannot be null") @PastOrPresent(message = "hire date cannot be in the future") LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
