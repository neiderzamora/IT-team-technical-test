package com.ITteam.technicaltest.service;

import com.ITteam.technicaltest.dto.EmployeeSalaryStatusDTO;
import com.ITteam.technicaltest.dto.EmployeeWithDetailsDTO;
import com.ITteam.technicaltest.exception.ResourceNotFoundException;
import com.ITteam.technicaltest.model.Employee;
import com.ITteam.technicaltest.repository.ApptestRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApptestService {
    @Autowired
    private ApptestRespository apptestRespository;

    public Employee createEmployee(Employee employee) {
        return apptestRespository.save(employee);
    }

    public Page<Employee> getEmployees(Pageable pageable) {
        return apptestRespository.findAll(pageable);
    }

    public Employee getEmployeeById(Long id) {
        return apptestRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = apptestRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setPosition(employeeDetails.getPosition());
        employee.setSalary(employeeDetails.getSalary());
        employee.setDepartment(employeeDetails.getDepartment());

        return apptestRespository.save(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = apptestRespository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        apptestRespository.delete(employee);
    }

    public List<Employee> getEmployeesWithOptionalDetails() {
        return apptestRespository.findEmployeesWithOptionalDetails();
    }

    public List<EmployeeWithDetailsDTO> getEmployeesWithDepartmentAndRole() {
        List<Object[]> employees = apptestRespository.findEmployeesWithDepartmentAndRole();

        return employees.stream().map(employee ->
                new EmployeeWithDetailsDTO(
                        (Long) employee[0],
                        (String) employee[1],
                        (String) employee[2],
                        (String) employee[3],
                        (Double) employee[4],
                        ((Date) employee[5]).toLocalDate(),
                        (String) employee[6],
                        (String) employee[7]
                )
        ).collect(Collectors.toList());
    }

    public List<EmployeeSalaryStatusDTO> getEmployeesWithSalaryStatus() {
        List<Object[]> employees = apptestRespository.findEmployeesWithSalaryStatus();

        return employees.stream().map(employee ->
                new EmployeeSalaryStatusDTO(
                        (Long) employee[0],
                        (String) employee[1],
                        (String) employee[2],
                        (String) employee[3],
                        (Double) employee[4],
                        ((Date) employee[5]).toLocalDate(),
                        (String) employee[6],
                        (String) employee[7]
                )
        ).collect(Collectors.toList());
    }

    public Page<Employee> getFilteredEmployees(String name, String departmentName, PageRequest pageRequest) {
        if (name == null && departmentName == null) {
            return apptestRespository.findAll(pageRequest);
        }
        return apptestRespository.findByNameContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(
                name != null ? name : "",
                departmentName != null ? departmentName : "",
                pageRequest
        );
    }

}
