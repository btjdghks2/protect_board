package com.example.ItemOrderUser.repository;


import com.example.ItemOrderUser.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
     //board id 가 동일한 모든 commentcontent 를 가져오는 쿼리
     @Query("SELECT comment.commentcontent FROM comment WHERE comment.board.id = :boardId")
     List<Comment> findByBoardId(Long id);
}
