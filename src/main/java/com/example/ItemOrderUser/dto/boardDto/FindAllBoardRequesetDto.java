package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindAllBoardRequesetDto {

    private Long boardId;
    private String title;
    private String content;

    @Builder
    public FindAllBoardRequesetDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
    }

}
