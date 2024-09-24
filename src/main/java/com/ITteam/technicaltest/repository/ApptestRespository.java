package com.ITteam.technicaltest.repository;

import com.ITteam.technicaltest.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ApptestRespository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e.* FROM employee e " +
            "LEFT JOIN department d ON e.department_id = d.id " +
            "LEFT JOIN role r ON e.role_id = r.id", nativeQuery = true)
    List<Employee> findEmployeesWithOptionalDetails();

    @Query(value = "SELECT e.id, e.name, e.email, e.position, e.salary, e.hire_date, " +
            "d.name AS department_name, r.name AS role_name " +
            "FROM employee e " +
            "LEFT JOIN department d ON e.department_id = d.id " +
            "LEFT JOIN role r ON e.role_id = r.id", nativeQuery = true)
    List<Object[]> findEmployeesWithDepartmentAndRole();

    @Query(value = "SELECT e.id, e.name, e.email, e.position, e.salary, e.hire_date, " +
            "d.name AS department_name, " +
            "CASE " +
            "   WHEN e.salary > (SELECT AVG(e2.salary) FROM employee e2 WHERE e2.department_id = e.department_id) " +
            "   THEN 'Above' " +
            "   ELSE 'Below' " +
            "END AS salary_status " +
            "FROM employee e " +
            "LEFT JOIN department d ON e.department_id = d.id",
            nativeQuery = true)
    List<Object[]> findEmployeesWithSalaryStatus();

    Page<Employee> findByNameContainingIgnoreCaseAndDepartment_NameContainingIgnoreCase(
            String name, String departmentName, PageRequest pageRequest);

}
