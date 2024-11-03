package com.example.Spring.Security.service;

import com.example.Spring.Security.model.USERDB;
import com.example.Spring.Security.model.UserPrinciple;
import com.example.Spring.Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        USERDB user =  userRepo.findByUsername(username);
        if(user==null)
        {
            System.out.println("nO uSER fOUND");
            throw  new UsernameNotFoundException("nO uSER fOUND");
        }
          return new UserPrinciple(user);
    }
}
