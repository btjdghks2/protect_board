package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.boardDto.*;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;


    //만들건, 글/쓰기, 글 /목록,글 상/세보기,글 수정하기,글 삭제


    // 글 목록 조회
    @GetMapping("/api")
    public List<FindAllBoardDto> home() {

        // 잠깐.. 그럼 이건..걍 뷰 컨트롤러에서 만들어도 되려나?
        List<FindAllBoardDto> result = boardService.boardFindAllService();

        return result;
    }

    // 글쓰기 , 리팩토링 완료
    @PostMapping("/api/new")
    public Long createBoard(@RequestBody CreateBoardDto createBoardDto) {

        Board board = createBoardDto.toEntity();

        board = boardRepository.save(board);

        return board.getId();
    }


    //글 상세 페이지
    @GetMapping("/api/detail/{id}")
    public FindByBoardDto detailBoard(@PathVariable Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

            return new FindByBoardDto(board);

    }
    // 글 삭제
    @DeleteMapping("/api/detail/delete/{id}")
    public DeleteBoardDto deleteBoard(@PathVariable Long id) {

        DeleteBoardDto result = boardService.boardDeleteService(id);


        return result;
    }

    // 글 수정
    @PutMapping("/api/detail/update/{id}")
    public UpdateBoardDto updateBoard(@PathVariable Long id,@RequestBody UpdateBoardDto updateBoardDto) {

        return boardService.boardUpdateService(id,updateBoardDto);

    }


}
