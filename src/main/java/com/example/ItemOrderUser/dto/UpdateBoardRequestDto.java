package com.example.ItemOrderUser.dto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateBoardRequestDto {


    private String title;
    private String content;

    @Builder
    public UpdateBoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public UpdateBoardRequestDto(Board board) {
        this.title = board.getTitle();
        this.content = board.getContent();
    }
}
