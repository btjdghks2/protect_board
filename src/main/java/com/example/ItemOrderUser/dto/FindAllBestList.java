package com.example.ItemOrderUser.dto;


import com.example.ItemOrderUser.domain.Board;
import lombok.Data;

@Data
public class FindAllBestList {

    private Long id;

    private String title;

    private String content;

    private int view;

    public FindAllBestList(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.view = board.getView();

    }
}
