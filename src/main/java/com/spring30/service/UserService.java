package com.spring30.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
    public Integer getUserId(){
        System.out.println("in Service getUserId");
        int userId = 5;
        return userId;
    }
}
