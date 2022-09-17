package com.example.thymeleaf_demo.services;

import com.example.thymeleaf_demo.entities.Employee;
import com.example.thymeleaf_demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;


    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> findAllEmployees() {
        return repo.findAllByOrderByLastNameAsc();
    }

    public Employee findEmployeeById(int id) {
        Optional<Employee> result = repo.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new RuntimeException("Employee not found with id - " + id);
        }
    }

    public void saveEmployee(Employee employee){
        repo.save(employee);
    }

    public void deleteEmployeeById(int id){
        repo.deleteById(id);
    }
}
