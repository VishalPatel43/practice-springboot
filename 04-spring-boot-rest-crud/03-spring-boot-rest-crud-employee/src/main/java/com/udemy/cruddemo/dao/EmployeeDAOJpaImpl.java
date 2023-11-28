package com.udemy.cruddemo.dao;

import com.udemy.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager

    private EntityManager theEntityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.theEntityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create a query
        TypedQuery<Employee> theQuery =
                theEntityManager.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        // get employee
        Employee theEmployee =
                theEntityManager.find(Employee.class, theId);

        // return employee

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {

        // save or update the employee (if id==0 then insert else update)
        Employee dbEmployee = theEntityManager.merge(theEmployee);

        // return updated employee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {

        // find employee by id
        Employee theEmployee =
                theEntityManager.find(Employee.class, theId);

        // remove employee
        theEntityManager.remove(theEmployee);
    }
}
