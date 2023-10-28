package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.dto.boardDto.CreateBoardDto;
import com.example.ItemOrderUser.dto.boardDto.FindAllBoardDto;
import com.example.ItemOrderUser.repository.BoardRepository;
import com.example.ItemOrderUser.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith({SpringExtension.class})
@Transactional
class BoardApiControllerTest {

    @Autowired
    @LocalServerPort
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private BoardService boardService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;



    @Test
    void home() throws Exception {


        //여기는 findall 기능을 담당하는 곳
        //여기서 해야할 테스트는, 기본적으로 값을 넣고,
        // 조회를 해서 비교값과 같은지 확인하는게 포인트
        //신경써야 할 것은 json으로 들어갈텐데, json값을 신경쓰면서 넣어야 한다

        //given
        Board board = new Board("제목1","내용");




    }

    @Test
    void createBoard() {

        // 먼저 해야 할 것은 메소드 기능대로 값을 넣는것
        // 두번째로는 넣은 값을 조회 하는것
        // 세번째로는 그 값이 지금 입력하는 값과 동일하다는 것

        String title = "title";
        String content = "content";

        CreateBoardDto requestDto = null;
        requestDto.setTitle(title);
        requestDto.setContent(content);

        String url = "http://localhost:" + port + "/api/new";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url,requestDto,Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);


// 여기서 값을 넣어놓고 비교 하는 방식으로 다시 가보자


    }

    @Test
    void detailBoard() {

        // Given


        // When


        // Then

    }

    @Test
    void deleteBoard() {
    }

    @Test
    void updateBoard() {
    }
}