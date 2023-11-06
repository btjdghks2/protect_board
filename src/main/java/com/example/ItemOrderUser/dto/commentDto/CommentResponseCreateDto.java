package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class CommentResponseCreateDto {

    private String commentcontent;

    public CommentResponseCreateDto(Comment comment) {
        this.commentcontent = comment.getCommentcontent();
    }
}
