package com.example.rbac.repository;

import com.example.rbac.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User , Integer> {

    User save(User user);

    List<User> findByNameIgnoreCaseStartingWith(String name);



}
