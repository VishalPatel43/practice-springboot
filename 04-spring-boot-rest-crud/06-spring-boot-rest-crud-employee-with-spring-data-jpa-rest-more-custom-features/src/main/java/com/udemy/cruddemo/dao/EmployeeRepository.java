package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") // this is optional --> we override with members instead of employees
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { // <Entity type, Primary Key>
    // that's it ... no need to write any code LOL!
}
