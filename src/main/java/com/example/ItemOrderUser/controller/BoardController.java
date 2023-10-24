package com.example.ItemOrderUser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/new")
    public String createpostPage() {
        return "createPage";
    }

    @GetMapping("/detail/{id}")
    public String detailPage() {
        return "detailPage";
    }

    @GetMapping("/detail/edit/{id}")
    public String editPage() {
        return "editPage";
    }
}
