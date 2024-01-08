package com.example.rbac.repository;


import com.example.rbac.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company , Integer> {

    Company save(Company company);

    List<Company> findByOwnerId(int userId);
}