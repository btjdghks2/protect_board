package com.example.ItemOrderUser.repository;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.FindAllBestList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BoardRepository extends JpaRepository<Board,Long> {

    @Query("SELECT b FROM Board b ORDER BY b.id DESC")
    List<Board> findAllDesc();

    @Query(value = "SELECT * FROM BOARD B WHERE B.view >10",nativeQuery = true)
    List<Board> findByViewGreaterThan(int viewCount);

    List<Board> findByTitleContaining(String keyword);

}
