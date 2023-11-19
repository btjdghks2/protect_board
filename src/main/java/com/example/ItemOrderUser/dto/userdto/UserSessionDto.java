package com.example.ItemOrderUser.dto.userdto;

import com.example.ItemOrderUser.domain.Role;
import com.example.ItemOrderUser.domain.User;

import java.io.Serializable;

public class UserSessionDto implements Serializable {
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Role role;

    public UserSessionDto(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
