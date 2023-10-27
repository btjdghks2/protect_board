package com.example.ItemOrderUser.dto.boardDto;

import lombok.Builder;

public class FindAllBoardDto {

    private String title;
    private String content;

    @Builder
    public FindAllBoardDto(String title,String content) {
        this.title = title;
        this.content = content;
    }

    public FindAllBoardDto() {

    }
}
