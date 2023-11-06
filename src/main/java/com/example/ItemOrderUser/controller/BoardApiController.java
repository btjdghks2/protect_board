package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.boardDto.*;
import com.example.ItemOrderUser.dto.commentDto.CommentResponseCreateDto;
import com.example.ItemOrderUser.dto.commentDto.FindAllCommentDto;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.service.BoardService;
import com.example.ItemOrderUser.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;
    private final CommentService commentService;


    //만들건, 글/쓰기, 글 /목록,글 상/세보기,글 수정하기,글 삭제


    // 글 목록 조회
    @GetMapping("/api")
    public List<FindAllBoardRequesetDto> home() {

        // 잠깐.. 그럼 이건..걍 뷰 컨트롤러에서 만들어도 되려나?
        List<FindAllBoardRequesetDto> result = boardService.boardFindAllService();

        return result;
    }

    // 글쓰기 , 리팩토링 완료
    @PostMapping("/api/new")
    public Long createBoard(@RequestBody CreateBoardRequestDto createBoardRequestDto) {

        Board board = createBoardRequestDto.toEntity();

        board = boardRepository.save(board);

        return board.getId();
    }





    //글 상세 페이지
    //여기서 댓글 불러오기 + 댓글작성
    @GetMapping("/api/detail/{id}")
    public FindByBoardRequestDto detailBoard(@PathVariable Long id) {

        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("글이 존재하지 않습니다"));

        List<FindAllCommentDto> comments = commentService.commentFindAllService(id);

        


        return new FindByBoardRequestDto(board);

    }
    // 글 삭제
    @DeleteMapping("/api/detail/delete/{id}")
    public DeleteBoardRequestDto deleteBoard(@PathVariable Long id) {

        DeleteBoardRequestDto result = boardService.boardDeleteService(id);


        return result;
    }

    // 글 수정
    @PutMapping("/api/detail/update/{id}")
    public UpdateBoardRequestDto updateBoard(@PathVariable Long id, @RequestBody UpdateBoardRequestDto updateBoardRequestDto) {

        return boardService.boardUpdateService(id, updateBoardRequestDto);

    }


}
