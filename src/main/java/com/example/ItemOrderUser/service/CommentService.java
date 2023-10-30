package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Comment;
import com.example.ItemOrderUser.dto.boardDto.FindAllBoardDto;
import com.example.ItemOrderUser.dto.commentDto.CommentCreateDto;
import com.example.ItemOrderUser.dto.commentDto.CommentDeleteDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private CommentRepository commentRepository;

    @Transactional
    public List<FindAllCommentDto> commentSaveService(Long id) {
        List<Comment> comment = commentRepository.findByBoardId(id);

        List<FindAllCommentDto> result = comment.stream()
                .map(b -> new FindAllCommentDto())
                .collect(toList());
        return result;
    }

    @Transactional
    public List<FindAllCommentDto> commentFindAllService(Long id) {
        List<Comment> comment = commentRepository.findByBoardId(id);

        List<FindAllCommentDto> result = comment.stream()
                .map(b -> new FindAllCommentDto())
                .collect(toList());
        return result;
    }


    @Transactional
    public CommentDeleteDto commentDeleteService(Long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다"));

        commentRepository.delete(comment);


        return new CommentDeleteDto(comment);
    }
}
