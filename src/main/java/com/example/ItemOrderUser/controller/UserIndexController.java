package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.userdto.UserDto;
import com.example.ItemOrderUser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserIndexController {

    private final UserService userService;

    @GetMapping("/auth/join")
    public String join() {
        return "/user/user-join";
    }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto userDto){
        userService.userJoin(userDto);
        return "redirect:/auth/login";

    }

    @GetMapping("/auth/login")
    public String login() {
        return "/user/user-login";
    }


}
