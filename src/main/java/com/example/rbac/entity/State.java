package com.example.rbac.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String state_code;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "state_id")
    private List<City> cities;
    // getters and setters
}