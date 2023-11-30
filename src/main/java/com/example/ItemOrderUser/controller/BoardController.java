package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.CommentResponseDto;
import com.example.ItemOrderUser.dto.FindByBoardRequestDto;
import com.example.ItemOrderUser.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {
    // 여기서 한다면 모델 어트리뷰트로 쏴주는 부분

    private final BoardService boardService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("board",boardService.mainList());


        return "main";
    }

    @GetMapping("/detail/{id}")
    public String deteailBoard(@PathVariable Long id,Model model) {

        FindByBoardRequestDto dto = boardService.findByBoardDetail(id);
        List<CommentResponseDto> comments = dto.getCommentList();

        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }
        model.addAttribute("board",boardService.findByBoardDetail(id));

        return "detailPage";
    }

    @GetMapping("/new")
    public String newBoard() {
        return "createPage";
    }

    @GetMapping("/detail/edit/{id}")
    public String editBoard(@PathVariable Long id,Model model) {
        FindByBoardRequestDto dto = boardService.findByBoardDetail(id);
        model.addAttribute("board",dto);
        return "editPage";
    }
}
