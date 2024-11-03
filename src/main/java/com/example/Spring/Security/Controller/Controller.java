package com.example.Spring.Security.Controller;


import com.example.Spring.Security.model.USERDB;
import com.example.Spring.Security.service.RegisterUser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class Controller {

    @Autowired
    private RegisterUser registerUser;

    @GetMapping("/api")
    public String getData(HttpServletRequest request){
        return "Welcome....!!!!"+request.getSession().getId();
    }

    @PostMapping("/register")
    public USERDB regiser(@RequestBody USERDB user){

        return registerUser.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody USERDB user){
          return  registerUser.verify(user);
    }
}
