package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Roles {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence5", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")
    private Long role_id;
    private String role_name;

    public Roles() {
    }

    public Roles(Long role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}