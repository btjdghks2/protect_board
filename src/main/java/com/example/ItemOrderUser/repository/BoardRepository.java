package com.example.ItemOrderUser.repository;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board,Long> {


    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllDesc();
}
