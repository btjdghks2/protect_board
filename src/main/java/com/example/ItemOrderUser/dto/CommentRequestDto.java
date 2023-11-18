package com.example.ItemOrderUser.dto;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CommentRequestDto {

    private Long id;
    private String commentcontent;
    private String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm"));
    private Board board;



    public Comment toEntity() {
        Comment comment = Comment.builder()
                .id(id)
                .commentcontent(commentcontent)
                .createdDate(createdDate)
                .modifiedDate(modifiedDate)
                .board(board)
                .build();
        return comment;

    }
}
