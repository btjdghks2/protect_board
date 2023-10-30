package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

public class DeleteBoardRequestDto {

    private Long id;
    private String title;
    private String content;


    public DeleteBoardRequestDto(Board board) {

        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
