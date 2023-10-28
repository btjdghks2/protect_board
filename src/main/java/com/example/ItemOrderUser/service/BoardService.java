package com.example.ItemOrderUser.service;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.boardDto.*;
import com.example.ItemOrderUser.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;


    @Transactional
    public UpdateBoardDto boardUpdateService(Long id,UpdateBoardDto updateBoardDto) {
        //조금 이상하다.. 그러니까 과정상 디티오로 받았어, 그다음 엔티티로 변환해야 되
        //엔티티에 넣고 다시 디티오로 변환해야돼

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        board.setTitle(updateBoardDto.getTitle());
        board.setContent(updateBoardDto.getContent());

        boardRepository.save(board);

        return new UpdateBoardDto(board);
    }

    @Transactional
    public List<FindAllBoardDto> boardFindAllService() {

        return boardRepository.findAllDesc().stream()
                .map(FindAllBoardDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public DeleteBoardDto boardDeleteService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다"));

        boardRepository.delete(board);

        return new DeleteBoardDto(board);
    }

    @Transactional
    public FindByBoardDto boardFindByIdService(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        return new FindByBoardDto(board);
    }
}
