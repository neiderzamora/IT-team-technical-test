package com.ITteam.technicaltest.controller;

import com.ITteam.technicaltest.dto.EmployeeSalaryStatusDTO;
import com.ITteam.technicaltest.dto.EmployeeWithDetailsDTO;
import com.ITteam.technicaltest.model.Employee;
import com.ITteam.technicaltest.service.ApptestService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class ApptestController {
    @Autowired
    public ApptestService apptestService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
        Employee newEmployee = apptestService.createEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getFilteredEmployees(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String departmentName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Employee> employees = apptestService.getFilteredEmployees(name, departmentName, pageRequest);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = apptestService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id, @Valid @RequestBody Employee employeeDetails) {
        Employee updateEmployee = apptestService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        apptestService.deleteEmployee(id);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/employees-dpt-rol")
    public ResponseEntity<List<Employee>> getEmployeesWithOptionalDetails() {
        List<Employee> employees = apptestService.getEmployeesWithOptionalDetails();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees-without-dpt-rol")
    public ResponseEntity<List<EmployeeWithDetailsDTO>> getEmployeesWithDetails() {
        List<EmployeeWithDetailsDTO> employees = apptestService.getEmployeesWithDepartmentAndRole();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/salary-status")
    public ResponseEntity<List<EmployeeSalaryStatusDTO>> getEmployeesWithSalaryStatus() {
        List<EmployeeSalaryStatusDTO> employees = apptestService.getEmployeesWithSalaryStatus();
        return ResponseEntity.ok(employees);
    }

}
