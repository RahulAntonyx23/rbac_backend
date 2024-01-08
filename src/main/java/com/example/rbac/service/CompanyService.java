package com.example.rbac.service;


import com.example.rbac.entity.Company;
import com.example.rbac.entity.Employee;
import com.example.rbac.entity.User;
import com.example.rbac.repository.CompanyRepository;
import com.example.rbac.repository.UserRepository;
import com.example.rbac.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Company> addCompanyToUser(int userId, Company company) {
        return userRepository.findById(userId).map(user -> {
            company.setOwner(user);
            return companyRepository.save(company);
        });
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public List<Company> getAllCompaniesByUser(int userId) {
        return companyRepository.findByOwnerId(userId);
    }

    public List<Employee> getAllEmployeesByCompany(int companyId) {
        return employeeRepository.findByCompanyId(companyId);
    }



    //search for user using name

}
