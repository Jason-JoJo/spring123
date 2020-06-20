package com.spring30.controller;


import com.spring30.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
@Component
public class UserController {

    @Autowired
    UserService userService = new UserService();

    @GetMapping("/")
    public String index(Map<String,Object> model){
        model.put("ID",userService.getUserId());
        return "index";
    }
    @GetMapping("/index.*")
    public String home(Map<String,Object> model){

        return "index";
    }
}
