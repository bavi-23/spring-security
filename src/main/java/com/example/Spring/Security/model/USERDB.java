package com.example.Spring.Security.model;


import jakarta.persistence.*;



@Entity(name = "UserDB")
@Table(name = "UserDB")
public class USERDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
