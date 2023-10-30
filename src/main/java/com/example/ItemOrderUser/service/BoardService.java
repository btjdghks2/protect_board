package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.boardDto.*;
import com.example.ItemOrderUser.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public UpdateBoardRequestDto boardUpdateService(Long id, UpdateBoardRequestDto updateBoardRequestDto) {
        //조금 이상하다.. 그러니까 과정상 디티오로 받았어, 그다음 엔티티로 변환해야 되
        //엔티티에 넣고 다시 디티오로 변환해야돼

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        board.setTitle(updateBoardRequestDto.getTitle());
        board.setContent(updateBoardRequestDto.getContent());

        boardRepository.save(board);

        return new UpdateBoardRequestDto(board);
    }

    @Transactional
    public List<FindAllBoardRequesetDto> boardFindAllService() {

        return boardRepository.findAllDesc().stream()
                .map(FindAllBoardRequesetDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public DeleteBoardRequestDto boardDeleteService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다"));

        boardRepository.delete(board);

        return new DeleteBoardRequestDto(board);
    }

    @Transactional
    public FindByBoardRequestDto boardFindByIdService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        return new FindByBoardRequestDto(board);
    }
}
