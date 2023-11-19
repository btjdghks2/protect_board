package com.example.ItemOrderUser.config;

import com.example.ItemOrderUser.domain.User;
import com.example.ItemOrderUser.dto.userdto.UserSessionDto;
import com.example.ItemOrderUser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final HttpSession session;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 존재하지 않습니다 :" + username));

        session.setAttribute("user", new UserSessionDto(user));
        return new CustomUserDetails(user);
    }
}
