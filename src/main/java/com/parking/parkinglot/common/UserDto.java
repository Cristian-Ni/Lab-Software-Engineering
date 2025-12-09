package com.parking.parkinglot.common;

import org.example.parkinglot.entities.Car;

import java.util.List;

public class UserDto
{
    Long id;
    String username;

    String email;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }



    public String getEmail() {
        return email;
    }

    public UserDto(String username, Long id, String email) {
        this.username = username;
        this.id = id;
        this.email = email;
    }
}