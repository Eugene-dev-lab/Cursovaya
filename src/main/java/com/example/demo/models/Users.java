package com.example.demo.models;

import jakarta.persistence.*;

@Entity
public class Users {
    @Id
    @SequenceGenerator(name = "pet_seq", sequenceName = "pet_sequence4", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pet_seq")
    private Long user_id;
    private Long client_id;
    private Long role_id;
    private String login, password;


    public Users() {

    }
    public Users(String login, String password, Long role_id, Long client_id) {
        this.client_id = client_id;
        this.role_id = role_id;
        this.login = login;
        this.password = password;
    }
    public Users(Long user_id, Long client_id, Long role_id, String login, String password) {
        this.user_id = user_id;
        this.client_id = client_id;
        this.role_id = role_id;
        this.login = login;
        this.password = password;
    }




    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}