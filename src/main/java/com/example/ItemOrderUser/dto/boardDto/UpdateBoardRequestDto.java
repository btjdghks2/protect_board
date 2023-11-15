package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {

    private Long id;
    private String title;
    private String content;

    public UpdateBoardRequestDto(String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public UpdateBoardRequestDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
