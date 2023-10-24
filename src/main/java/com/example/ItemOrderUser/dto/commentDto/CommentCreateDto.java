package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import lombok.Builder;

public class CommentCreateDto {
    private String commentcontent;

    @Builder
    public Comment toEntity() {
        return Comment.builder()
                .commentcontent(commentcontent)
                .build();
    }
}
