package com.research.librarymanager_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.research.librarymanager_backend.Models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
