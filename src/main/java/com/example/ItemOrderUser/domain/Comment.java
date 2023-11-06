package com.example.ItemOrderUser.domain;

import com.example.ItemOrderUser.dto.commentDto.CommentRequestCreateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;

    @Column
    private String commentcontent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    @Builder
    public Comment( String commentcontent) {

        this.commentcontent = commentcontent;
    }



    public static Comment createComment(Comment create) {
    }
}
