package com.example.ItemOrderUser.dto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Data;

@Data
public class FindAllBoardList {

    private Long id;

    private String title;

    private String content;



    public FindAllBoardList(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();

    }
}
