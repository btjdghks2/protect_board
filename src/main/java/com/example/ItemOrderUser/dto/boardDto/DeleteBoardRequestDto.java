package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

public class DeleteBoardRequestDto {

    private Long boardId;
    private String title;
    private String content;


    public DeleteBoardRequestDto(Board board) {

        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
