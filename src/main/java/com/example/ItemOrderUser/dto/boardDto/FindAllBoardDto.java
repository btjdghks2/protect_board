package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindAllBoardDto {

    private Long id;
    private String title;
    private String content;

    @Builder
    public FindAllBoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
    }

}
