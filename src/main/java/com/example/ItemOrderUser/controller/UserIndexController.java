package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.userdto.UserDto;
import com.example.ItemOrderUser.dto.userdto.UserRequestDto;
import com.example.ItemOrderUser.dto.userdto.UserSessionDto;
import com.example.ItemOrderUser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import javax.validation.constraints.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

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

    //회원가입
    @PostMapping("/auth/joinProc")
    public String joinProc(@Valid UserRequestDto userDto, Errors errors, Model model){

        if(errors.hasErrors()) {
            //회원 가입 실패시 입력 데이터 값을 유지
            model.addAttribute("userDto",userDto);

            // 유효성 통과 못한 필드와 메세지를 핸들링
            Map<String,String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }
            // 회원가입 페이지로 다시 리턴
            return "join";
        }
        userService.userJoin(userDto);
        return "redirect:/login";

    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        UserSessionDto user = (UserSessionDto) session.getAttribute("user"); if (user != null) {
            model.addAttribute("user", user.getNickname());
        }
        return "/user/user-login";
    }





}
