package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {

    private Long boardId;
    private String title;
    private String content;

    public UpdateBoardRequestDto(String title, String content) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
    }

    public UpdateBoardRequestDto(Board board) {
        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
