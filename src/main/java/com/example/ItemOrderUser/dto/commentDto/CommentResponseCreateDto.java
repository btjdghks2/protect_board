package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;
import lombok.Builder;

public class CommentResponseCreateDto {

    private String commentcontent;

    public CommentResponseCreateDto(Comment  comment) {
        this.commentcontent = comment.getCommentcontent();
    }
}
