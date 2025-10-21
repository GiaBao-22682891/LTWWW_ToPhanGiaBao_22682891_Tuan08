package org.example.springwebmvc.service;

import org.example.springwebmvc.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee (Employee employee);

    public List<Employee> listOfEmployees();

    public void deleteEmployeeByID (int id);
}
