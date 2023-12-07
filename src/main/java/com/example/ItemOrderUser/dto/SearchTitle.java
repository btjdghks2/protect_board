package com.example.ItemOrderUser.dto;

import com.example.ItemOrderUser.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SearchTitle {

    private Long id;

    private String title;


    private int view;

    private String createdAt;

    public SearchTitle(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.view = board.getView();
        this.createdAt = board.getCreatedAt();
    }
}
