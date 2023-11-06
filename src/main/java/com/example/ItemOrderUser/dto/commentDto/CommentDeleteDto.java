package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;

public class CommentDeleteDto {
    private Long commentId;
    private String commentContent;
    public CommentDeleteDto(Comment comment) {

        this.commentId = comment.getCommentId();
        this.commentContent = comment.getCommentcontent();
    }
}
