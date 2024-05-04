package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private MyBean myBean;

    @Autowired
    public UserService(MyBean myBean) {
        this.myBean = myBean;
    }

    public void printUserInfo() {
        System.out.println("Username: " + myBean.getUsername());
        System.out.println("Email: " + myBean.getEmail());
    }
}