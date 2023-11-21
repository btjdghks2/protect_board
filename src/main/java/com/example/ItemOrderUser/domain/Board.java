package com.example.ItemOrderUser.domain;

import com.example.ItemOrderUser.domain.time.BaseTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends BaseTime {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    private User user;

    @Column
    private String title;

    @Column
    private String content;



    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL)
    private List<Comment> comment = new ArrayList<>();


    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
