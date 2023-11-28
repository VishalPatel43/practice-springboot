package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <Entity type, Primary Key>
    // that's it ... no need to write any code LOL!
}
