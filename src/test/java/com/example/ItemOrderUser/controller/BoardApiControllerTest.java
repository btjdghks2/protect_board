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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
@ExtendWith({SpringExtension.class})
class BoardApiControllerTest {

    @Autowired
    private MockMvc mvc;

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
        mvc.perform(MockMvcRequestBuilders.get("/")

                .accept(status().isOk())
        )



    }

    @Test
    void createBoard() {

        // 먼저 해야 할 것은 메소드 기능대로 값을 넣는것
        // 두번째로는 넣은 값을 조회 하는것
        // 세번째로는 그 값이 지금 입력하는 값과 동일하다는 것
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