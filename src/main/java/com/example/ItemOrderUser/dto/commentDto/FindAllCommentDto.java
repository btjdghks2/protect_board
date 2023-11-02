package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Data
@Setter
@NoArgsConstructor
public class FindAllCommentDto {

    private Long id;
    private String commentcontent;


    public FindAllCommentDto(Comment comment) {
        comment.getId();
        comment.getBoard().getId();
        comment.getCommentcontent();

    }
}
