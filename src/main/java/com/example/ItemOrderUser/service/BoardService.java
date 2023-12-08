package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.domain.Comment;
import com.example.ItemOrderUser.dto.*;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;


//    @Transactional
//    public List<FindAllBoardList> mainList(Pageable pageable) {
//
//        return boardRepository.findAllDesc().stream()
//                .map(FindAllBoardList::new)
//                .collect(Collectors.toList());
//
//    }

    @Transactional
    public Page<Board> Pagingser(Pageable pageable) {

        return boardRepository.findAll(pageable);

    }


    @Transactional
    public FindByBoardRequestDto findByBoardDetail(Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 글입니다"));

        board.setView(board.getView() +1);


        return new FindByBoardRequestDto(board);

    }

    @Transactional
    public Long editBoardService(Long id, UpdateBoardRequestDto updateBoardRequestDto) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));
        board.setTitle(updateBoardRequestDto.getTitle());
        board.setContent(updateBoardRequestDto.getContent());


        return id;

    }

    @Transactional
    public Long commentSave(Long id, CommentRequestDto commentRequestDto) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        commentRequestDto.setBoard(board);

        Comment comment = commentRequestDto.toEntity();
        commentRepository.save(comment);




        return commentRequestDto.getId();
    }


    @Transactional
    public List<FindAllBestList> bestList() {

        return boardRepository.findByViewGreaterThan(10).stream()
                .map(FindAllBestList::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<SearchTitle> search(String keyword) {

        return boardRepository.findByTitleContaining(keyword).stream()
                .map(SearchTitle::new)
                .collect(Collectors.toList());

    }


}
