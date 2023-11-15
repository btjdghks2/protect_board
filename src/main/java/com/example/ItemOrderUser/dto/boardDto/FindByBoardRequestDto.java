package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

import java.util.List;

public class FindByBoardRequestDto {

    private Long id;
    private String title;
    private String content;



    public FindByBoardRequestDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;

    }

    public FindByBoardRequestDto(Board board) {

        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
