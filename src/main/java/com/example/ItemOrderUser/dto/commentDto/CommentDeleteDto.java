package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;

public class CommentDeleteDto {
    private Long id;
    private String commentContent;
    public CommentDeleteDto(Comment comment) {

        this.id = comment.getId();
        this.commentContent = comment.getCommentcontent();
    }
}
