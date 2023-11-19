package com.example.ItemOrderUser.dto.userdto;

import com.example.ItemOrderUser.domain.Role;
import com.example.ItemOrderUser.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String username;

    private String password;

    private String nickname;

    private String email;

    private Role role;

    public User toEntity() {
        User user = User.builder()
                .username(username)
                .password(password)
                .nickname(nickname)
                .email(email)
                .role(role.USER)
                .build();
        return user;
    }
}
