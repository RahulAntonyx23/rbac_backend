package com.example.rbac;

import com.example.rbac.entity.Country;
import com.example.rbac.repository.CountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

@SpringBootApplication
public class RbacApplication {


	public static void main(String[] args) {
		SpringApplication.run(RbacApplication.class, args);
	}




}
