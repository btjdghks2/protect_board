package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FindAllBoardRequesetDto {

    private Long id;
    private String title;


    @Builder
    public FindAllBoardRequesetDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
    }

}
