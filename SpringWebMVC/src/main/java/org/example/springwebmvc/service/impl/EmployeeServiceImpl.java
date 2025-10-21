package org.example.springwebmvc.service.impl;

import org.example.springwebmvc.model.Employee;
import org.example.springwebmvc.repositories.EmployeeRepositories;
import org.example.springwebmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepositories employeeRepositories;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepositories employeeRepositories) {
        this.employeeRepositories = employeeRepositories;
    }

    @Transactional
    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepositories.save(employee);
    }

    @Override
    public List<Employee> listOfEmployees() {
        return employeeRepositories.findAll();
    }

    @Override
    public void deleteEmployeeByID(int id) {
        employeeRepositories.deleteById(id);
    }
}
