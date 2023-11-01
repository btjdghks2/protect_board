package com.example.ItemOrderUser.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @PostMapping("/login")
    public String login() {
        return null;
    }


}
