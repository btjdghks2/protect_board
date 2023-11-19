package com.example.ItemOrderUser.config;

import com.example.ItemOrderUser.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final User user;

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { // 계정 만료여부 true : 만료 안됨
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { // 계정 잠김여부 true : 잠기지 않음
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { // 비밀번호 만료 여부 : true : 만료 안됨,false: 만료
        return false;
    }

    @Override
    public boolean isEnabled() { // 사용자 활성화 여부 : true : 만료 안됨 , false: 만료
        return false;
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();

        collectors.add(() -> "ROLE_"+ user.getRole());
        return collectors;
    }
}
