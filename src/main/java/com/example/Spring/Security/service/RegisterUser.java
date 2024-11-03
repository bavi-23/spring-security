package com.example.Spring.Security.service;


import com.example.Spring.Security.model.USERDB;
import com.example.Spring.Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUser {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

     public USERDB register(USERDB user){
         user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
     }

     public String verify(USERDB user){

        Authentication  authenticate= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
         if(authenticate.isAuthenticated())
           return jwtService.generateToken(user.getUsername());
         return "Failed";
     }
}
