package com.udemy.cruddemo.service;

import com.udemy.cruddemo.dao.EmployeeDAO;
import com.udemy.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO theEmployeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        this.theEmployeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return theEmployeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return theEmployeeDAO.findById(theId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return theEmployeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        theEmployeeDAO.deleteById(theId);
    }
}