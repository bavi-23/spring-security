package com.example.Spring.Security.repo;

import com.example.Spring.Security.model.USERDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<USERDB, Integer> {
    USERDB findByUsername(String username);
}
