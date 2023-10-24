package com.example.ItemOrderUser.repository;


import com.example.ItemOrderUser.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

     List<Comment> findByBoardId(Long id);
}
