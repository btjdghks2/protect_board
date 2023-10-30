package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class CommentRequestCreateDto {
    private String commentcontent;

    public CommentRequestCreateDto(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    @Builder
    public Comment toEntity() {
        return Comment.builder()
                .commentcontent(commentcontent)
                .build();
    }
}
