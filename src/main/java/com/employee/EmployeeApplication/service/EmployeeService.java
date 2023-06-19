package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>(Arrays.asList(
            new Employee(1, "First Employee", "Mechanicsburg"),
            new Employee(2, "Second Employee", "Harrisburg")
    )
    );

    @Autowired
    private EmployeeRepository employeeRepository;


     public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();
     }

     public Employee getAnEmployee(int id){
         return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
     }

     public void createEmployee(Employee employee){
         employeeRepository.save(employee);
     }

     public void updateEmployee(Employee employee){
         employeeRepository.save(employee);
     }

     public void deleteEmployee(int id){
         employeeRepository.delete(employeeRepository.getById(id));
     }
}
