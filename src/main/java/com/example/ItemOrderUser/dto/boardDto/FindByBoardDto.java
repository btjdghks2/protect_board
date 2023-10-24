package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

public class FindByBoardDto {

    private Long id;
    private String title;
    private String content;


    public FindByBoardDto(Board board) {

        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
