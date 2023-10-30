package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

public class CreateBoardResponseDto {

    private String title;
    private String content;


    public CreateBoardResponseDto(Board board) {

        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
