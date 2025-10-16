package org.example.springwebmvc.repositories;

import org.example.springwebmvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepositories extends JpaRepository <Employee, Integer> {
}
