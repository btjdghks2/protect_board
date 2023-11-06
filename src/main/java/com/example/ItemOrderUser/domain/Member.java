package com.example.ItemOrderUser.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memberId")
    private Long memberId;

    @Column
    private String username;

    @Column
    private String email;


    @OneToMany(mappedBy = "member")
    private List<Board> board = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<Comment> comment = new ArrayList<>();

}
