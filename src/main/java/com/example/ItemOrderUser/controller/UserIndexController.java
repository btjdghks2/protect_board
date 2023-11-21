package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.userdto.UserDto;
import com.example.ItemOrderUser.dto.userdto.UserSessionDto;
import com.example.ItemOrderUser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserIndexController {

    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/auth/join")
    public String join(Model model) {
        UserSessionDto user = (UserSessionDto) session.getAttribute("user"); if (user != null) {
            model.addAttribute("user", user.getNickname());
        }

        return "/user/user-join";
    }

    @PostMapping("/auth/joinProc")
    public String joinProc(UserDto userDto, Model model){
        UserSessionDto user = (UserSessionDto) session.getAttribute("user"); if (user != null) {
            model.addAttribute("user", user.getNickname());
        }
        userService.join(userDto);
        return "redirect:/auth/login";

    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        UserSessionDto user = (UserSessionDto) session.getAttribute("user"); if (user != null) {
            model.addAttribute("user", user.getNickname());
        }
        return "/user/user-login";
    }


}
