package com.example.ItemOrderUser.controller;

import com.example.ItemOrderUser.domain.Board;
import com.example.ItemOrderUser.service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class BoardApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BoardService boardService;


    @Test
    void home() throws Exception {
        Board board = new Board("제목1","내용");


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