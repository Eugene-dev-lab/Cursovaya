package com.example.demo.Controllers;

public class AuthUser {

    private Long user_id;
    private boolean isAuthorized = false;
    private String role_name = "user";


    public AuthUser(boolean isAuthorized, String role_name) {
        this.isAuthorized = isAuthorized;
        this.role_name = role_name;
    }

    public AuthUser(Long user_id, boolean isAuthorized, String role_name) {
        this.user_id = user_id;
        this.isAuthorized = isAuthorized;
        this.role_name = role_name;
    }

    public AuthUser() {
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getrole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}

