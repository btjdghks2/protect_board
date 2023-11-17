package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.dto.commentDto.CommentAllDto;
import com.example.ItemOrderUser.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final BoardService boardService;

    @GetMapping("/api/comment/list")
    public List<CommentAllDto> commentFindAll() {

        //가져오려면 일단 게시글의 아이디를 가져와서

        return null;
    }
}
