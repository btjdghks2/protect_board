package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Comment;
import com.example.ItemOrderUser.dto.commentDto.CommentRequestCreateDto;
import com.example.ItemOrderUser.dto.commentDto.CommentDeleteDto;
import com.example.ItemOrderUser.dto.commentDto.CommentResponseCreateDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.repository.CommentRepository;
import com.example.ItemOrderUser.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {



    private final CommentRepository commentRepository;
    private final CommentService commentService;

    @GetMapping("/api/detail/{boardId}/commentNew")
    public List<FindAllCommentDto> commentAll(@PathVariable Long boardId){
        List<FindAllCommentDto> findAllCommentDtos = commentService.commentFindAllService(boardId);

        return findAllCommentDtos;
    }

}
