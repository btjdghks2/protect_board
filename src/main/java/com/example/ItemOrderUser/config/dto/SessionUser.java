package com.example.ItemOrderUser.config.dto;

import com.example.ItemOrderUser.domain.User;

public class SessionUser {
    private String name;
    private String email;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
