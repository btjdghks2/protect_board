package com.example.ItemOrderUser.domain;

import com.example.ItemOrderUser.dto.commentDto.CommentRequestCreateDto;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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

    public static Comment createComment(CommentRequestCreateDto commentRequestCreateDto,Board board) {
        if (commentRequestCreateDto.getId() != null)
            throw new IllegalArgumentException("댓글 생성 실패! 댓글의 id가 없어야 합니다.");
        if (commentRequestCreateDto.getPageentityId() != pageentity.getId())
            throw new IllegalArgumentException("댓글 생성 실패! 게시글의 id가 잘못되었습니다.");
        // 엔티티 생성 및 반환
        return new Comment(
                dto.getId(),
                pageentity,
                dto.getNickname(),
                dto.getBody());
    }

    public static Comment createComment(Comment create) {
    }
}
