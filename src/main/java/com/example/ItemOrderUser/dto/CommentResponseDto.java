package com.example.ItemOrderUser.dto;

import com.example.ItemOrderUser.domain.Comment;
import lombok.Data;

@Data
public class CommentResponseDto {
    private Long id;
    private String commentcontent;
    private String createdDate;
    private Long boardId;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.commentcontent = comment.getCommentcontent();
        this.createdDate = comment.getCreatedDate();
        this.boardId = comment.getBoard().getId();
    }
}
