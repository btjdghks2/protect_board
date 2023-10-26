package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.service.BoardService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ExtendWith({SpringExtension.class})
class BoardApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;


    @Test
    void home() throws Exception {


        //여기는 findall 기능을 담당하는 곳
        //여기서 해야할 테스트는, 기본적으로 값을 넣고,
        // 조회를 해서 비교값과 같은지 확인하는게 포인트
        //신경써야 할 것은 json으로 들어갈텐데, json값을 신경쓰면서 넣어야 한다

        //given
        Board board = new Board("제목1","내용");

        //비교값 넣기
        mockMvc.perform("/")



    }

    @Test
    void createBoard() {
    }

    @Test
    void detailBoard() {
    }

    @Test
    void deleteBoard() {
    }

    @Test
    void updateBoard() {
    }
}