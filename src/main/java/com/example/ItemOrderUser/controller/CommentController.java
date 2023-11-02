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

    //코멘트의 경우 모든 기능이 디테일 페이지에서 만들어진다
    //따라서 기본 경로는 디테일 페이지, 그리고 아이디의 경우 글 아이디랑 겹치지 않게 하는것도 포인트

    //우선 기본적인 기능부터 만들건데 /댓글 전체 보기, /댓글 작성

    // 일단 기본적인 리팩토링은 되었다, 그렇다면 이 댓글이 게시글에 따라 맞춰서 보여줘야 하는게 포인트가 될것이다

    private final CommentRepository commentRepository;
    private final CommentService commentService;

//    @GetMapping("/api/detail/comment/{id}")
//    public List<FindAllCommentDto> readComment(@PathVariable Long id) {
//
//        List<FindAllCommentDto> result = commentService.commentSaveService(id);
//
//
//        return result;
//    }

    @PostMapping("/api/detail/{id}/new")
    public Long createcomment(@PathVariable Long id,@RequestBody CommentRequestCreateDto commentRequestCreateDto) {

        commentRequestCreateDto = commentService.commentSaveService(id, commentRequestCreateDto);

        Comment comment = commentRequestCreateDto.toEntity();

        commentRepository.save(comment);

        return comment.getId();
    }

    @DeleteMapping("/api/detail/delete/comment/{id}")
    public CommentDeleteDto deletecomment(@PathVariable Long id) {

        CommentDeleteDto result = commentService.commentDeleteService(id);

        return result;


    }

}
