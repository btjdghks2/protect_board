package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.boardDto.FindByBoardDto;
import com.example.ItemOrderUser.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("board", boardService.boardFindAllService());

        return "main";
    }

    @GetMapping("/new")
    public String createpostPage() {
        return "createPage";
    }

    @GetMapping("/detail/{id}")
    public String detailPage(Model model, @PathVariable Long id) {
        model.addAttribute("board", boardService.boardFindByIdService(id));

        return "detailPage";
    }

    @GetMapping("/detail/edit/{id}")
    public String editPage(Model model, @PathVariable Long id) {
        FindByBoardDto dto = boardService.boardFindByIdService(id);
        model.addAttribute("board", dto);
        return "editPage";
    }
}
