package com.example.ItemOrderUser.dto.boardDto;

import com.example.ItemOrderUser.domain.Board;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
public class CreateBoardRequestDto {


    private String title;
    private String content;


    public CreateBoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Builder
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }


}
