package com.example.ItemOrderUser.dto.commentDto;

import com.example.ItemOrderUser.domain.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestCreateDto {

    private Long id;
    private String commentcontent;
    @JsonProperty("board_id")
    private Long boardId;



    public static CommentRequestCreateDto createComment(Comment comment) {
        return new CommentRequestCreateDto(
                comment.getCommentId(),
                comment.getCommentcontent(),
                comment.getBoard().getBoardId());


    }

    @Builder
    public Comment toEntity() {
        return Comment.builder()
                .commentcontent(commentcontent)
                .build();
    }
}
