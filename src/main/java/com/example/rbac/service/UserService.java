package com.example.rbac.service;

import com.example.rbac.entity.Employee;
import com.example.rbac.entity.User;
import com.example.rbac.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rbac.repository.UserRepository;
import com.example.rbac.entity.Company;
import com.example.rbac.repository.CompanyRepository;

import java.util.List;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Employee addEmployeeToCompany(int companyId, int userId, String role , int hierarchy) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found"));

        Employee employee = new Employee();
        employee.setUser(user);
        employee.setCompany(company);
        employee.setRole(role);
        employee.setHierarchy(hierarchy);
        return employeeRepository.save(employee);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Employee> getAllUsersByCompany(int companyId) {
        return employeeRepository.findByCompanyId(companyId);
    }

    public List<User> getAllUsersByName(String name) {
        return userRepository.findByNameIgnoreCaseStartingWith(name);
    }









}
