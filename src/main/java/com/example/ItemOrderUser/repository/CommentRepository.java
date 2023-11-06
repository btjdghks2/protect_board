package com.example.ItemOrderUser.repository;


import com.example.ItemOrderUser.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {


     List<Comment> findAllByBoardId(Long id);


     @Query(value = "SELECT * FROM comment WHERE comment.board_id = :boardId",nativeQuery = true)
     List<Comment> findByBoardId(@Param("boardId")Long boardId);


}
