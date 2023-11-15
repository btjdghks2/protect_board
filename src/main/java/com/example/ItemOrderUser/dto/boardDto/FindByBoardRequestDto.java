package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

import java.util.List;

public class FindByBoardRequestDto {

    private Long boardId;
    private String title;
    private String content;



    public FindByBoardRequestDto(Long boardId, String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;

    }

    public FindByBoardRequestDto(Board board) {

        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
