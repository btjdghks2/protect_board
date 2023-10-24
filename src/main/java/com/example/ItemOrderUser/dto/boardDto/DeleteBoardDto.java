package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

public class DeleteBoardDto {

    private Long id;
    private String title;
    private String content;


    public DeleteBoardDto(Board board) {

        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
