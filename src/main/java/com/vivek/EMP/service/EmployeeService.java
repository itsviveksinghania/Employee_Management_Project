package com.vivek.EMP.service;

import com.vivek.EMP.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    //Create
    public Employee addEmployee(Employee employee);

    //Delete
    public String removeEmployee(int id);

    //Read
    public Optional<Employee> findEmpById(int id);

    public List<Employee> getAllEmployee();

    //Update
    public String updateEmployee(int id, Employee employee);
}
