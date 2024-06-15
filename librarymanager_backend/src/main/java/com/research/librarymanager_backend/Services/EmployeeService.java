package com.research.librarymanager_backend.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.research.librarymanager_backend.Models.Employee;
import com.research.librarymanager_backend.Repositories.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get All employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get Employee by Id
    public Employee getEmployeeById(Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.orElse(null);
    }

    // Create an employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Update an Employee
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setFirstName(employee.getFirstName());
            updatedEmployee.setLastName(employee.getLastName());
            updatedEmployee.setPhone(employee.getPhone());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setAddress(employee.getAddress());
            updatedEmployee.setHiredDate(employee.getHiredDate());
            updatedEmployee.setJobRole(employee.getJobRole());
            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }

    // Delete an employee
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
