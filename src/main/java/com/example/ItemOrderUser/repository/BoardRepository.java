package com.example.ItemOrderUser.repository;

import com.example.ItemOrderUser.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Long> {


    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllDesc();

    @Query("select comment c from board b " +
            "join fetch board.comment")
    public Board commentBoardFindAll(Long id);
}
