package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;

import java.util.List;

public class FindByBoardRequestDto {

    private Long id;
    private String title;
    private String content;

    private List<Comment> comments;

    public FindByBoardRequestDto(Long id, String title, String content, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public FindByBoardRequestDto(Board board) {

        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
