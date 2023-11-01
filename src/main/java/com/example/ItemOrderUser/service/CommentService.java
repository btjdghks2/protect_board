package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import com.example.ItemOrderUser.dto.commentDto.CommentDeleteDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public List<FindAllCommentDto> commentSaveService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        List<Comment> comment = commentRepository.findAllByBoardId(board.getId());

        List<FindAllCommentDto> result = comment.stream()
                .map(b -> new FindAllCommentDto())
                .collect(toList());
        return result;
    }

    @Transactional
    public List<FindAllCommentDto> commentFindAllService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));

        List<Comment> comment = commentRepository.findAllByBoardId(board.getId());

        if (comment.isEmpty()) {
            return null;
        }

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
