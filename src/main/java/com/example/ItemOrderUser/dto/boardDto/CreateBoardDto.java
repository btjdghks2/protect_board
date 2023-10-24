package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Data;

@Data
public class CreateBoardDto {


    private String title;
    private String content;

    public CreateBoardDto(Board board){

        this.title = board.getTitle();
        this.content = board.getContent();
    }

    @Builder
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }


}
