package com.example.rbac.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
    @Data
    @Table(name = "city")
    public class City {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String name;

        // getters and setters
    }


