package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.boardDto.FindByBoardRequestDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.service.BoardService;
import com.example.ItemOrderUser.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    private final CommentService commentService;

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

        List<FindAllCommentDto> findAllCommentDto = commentService.commentFindAllService(id);
        model.addAttribute("board", boardService.boardFindByIdService(id));
        model.addAttribute("comment", findAllCommentDto);

        return "detailPage";
    }

    @GetMapping("/detail/edit/{id}")
    public String editPage(Model model, @PathVariable Long id) {
        FindByBoardRequestDto dto = boardService.boardFindByIdService(id);
        model.addAttribute("board", dto);
        return "editPage";
    }
}
