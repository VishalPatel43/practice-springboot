package com.udemy.cruddemo.service;

import com.udemy.cruddemo.dao.EmployeeRepository;
import com.udemy.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository theEmployeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
        this.theEmployeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return theEmployeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
//        final var result = theEmployeeRepository.findById(theId);
        Optional<Employee> result = theEmployeeRepository.findById(theId);

        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return theEmployeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        theEmployeeRepository.deleteById(theId);
    }
}