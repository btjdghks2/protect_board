package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import com.example.ItemOrderUser.dto.commentDto.CommentDeleteDto;
import com.example.ItemOrderUser.dto.commentDto.CommentRequestCreateDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentRequestCreateDto commentSaveService(Long boardId,CommentRequestCreateDto commentRequestCreateDto) {
        Comment comment = new Comment();
        comment.setId(commentRequestCreateDto.getId());
        comment.setCommentcontent(commentRequestCreateDto.getCommentcontent());


        // 그러니까 문제점은 댓글 저장을 하는데
    }

    @Transactional
    public List<FindAllCommentDto> commentFindAllService(Long boardId) {

        List<Comment> comments = commentRepository.findByBoardId(boardId);

        List<FindAllCommentDto> result = commentRepository.findByBoardId(boardId)
                .stream()
                .map(comment -> FindAllCommentDto.createCommentDto(comment))
                .collect(Collectors.toList());


        return result;




    }


    @Transactional
    public CommentDeleteDto commentDeleteService(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다"));

        commentRepository.delete(comment);


        return new CommentDeleteDto(comment);
    }
}
