package com.example.rbac.controller;

import com.example.rbac.entity.Company;
import com.example.rbac.entity.Employee;
import com.example.rbac.entity.User;
import com.example.rbac.repository.CompanyRepository;
import com.example.rbac.repository.UserRepository;
import com.example.rbac.service.CompanyService;
import com.example.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class rbacController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/{userId}/companies")
    public Company addCompanyToUser(@PathVariable int userId, @RequestBody Company company) {
        return companyService.addCompanyToUser(userId, company).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @GetMapping("/users/{userId}/companies")
    public List<Company> getAllCompaniesByUser(@PathVariable int userId) {
        return companyService.getAllCompaniesByUser(userId);
    }

    @PostMapping("/companies/{companyId}/addEmployee/{userId}")
    public Employee addEmployeeToCompany(@PathVariable int companyId, @PathVariable int userId, @RequestBody Map<String, String> body) {
        return userService.addEmployeeToCompany(companyId, userId, body.get("role"), Integer.parseInt(body.get("hierarchy")));
    }

    @GetMapping("/companies/{companyId}/employees")
    public List<Employee> getAllEmployeesByCompany(@PathVariable int companyId) {
        return companyService.getAllEmployeesByCompany(companyId);
    }

    @GetMapping("/userByName")
    public List<User> getAllUsersByName(@RequestParam String name) {
        return userService.getAllUsersByName(name);
    }






}
