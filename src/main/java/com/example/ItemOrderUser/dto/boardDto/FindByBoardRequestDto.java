package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;

import java.util.List;

public class FindByBoardRequestDto {

    private Long boardId;
    private String title;
    private String content;

    private List<Comment> comments;

    public FindByBoardRequestDto(Long boardId, String title, String content, List<Comment> comments) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public FindByBoardRequestDto(Board board) {

        this.boardId = board.getBoardId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
