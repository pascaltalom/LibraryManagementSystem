package com.research.librarymanager_backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Exceptions.EmployeeNotFoundException;
import com.research.librarymanager_backend.Models.Employee;
import com.research.librarymanager_backend.Repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Get All employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Member by Id
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("Member with id"+ employeeId +"Not Found"));
    }

    // Create an employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update Employee
    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    // Delete an employee
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
