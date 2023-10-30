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
        this.id = comment.getId();
        this.commentcontent = comment.getCommentcontent();

    }
}
