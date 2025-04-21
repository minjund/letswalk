package com.minjun.letswalk.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minjun.letswalk.api.dto.BoardAppendRequest;
import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.service.board.BoardService;
import com.minjun.letswalk.service.board.query.BoardSearchService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = BoardController.class)
class BoardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private BoardService boardService;

    @MockitoBean
    private BoardSearchService boardSearchService;

    @DisplayName("신규 게시판을 등록한다.")
    @Test
    void createBoard() throws Exception {
        // given
        BoardAppendRequest boardAppendRequest = BoardAppendRequest.builder()
                .title("나랑 산책 갈 사람")
                .content("나랑 산책 갈 남자만 구해요")
                .recruitPersonnel(2)
                .recruitGenderType("male")
                .build();

        // when //then
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/v1/board")
                        .content(objectMapper.writeValueAsString(boardAppendRequest))
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
    }

    @DisplayName("신규 게시판을 등록할 때 제목은 필수 값이다")
    @Test
    void createBoardWithOutTitle() throws Exception {
        // given
        BoardAppendRequest boardAppendRequest = BoardAppendRequest.builder()
                .content("아아")
                .recruitPersonnel(2)
                .recruitGenderType("male")
                .build();

        // when //then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/v1/board")
                                .content(objectMapper.writeValueAsString(boardAppendRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("제목 입력은 필수 입니다."))
                .andExpect(jsonPath("$.data").isEmpty())
        ;
    }

    @DisplayName("신규 게시판을 등록할 때 내용은 필수 값이다")
    @Test
    void createBoardWithOutContent() throws Exception {
        // given
        BoardAppendRequest boardAppendRequest = BoardAppendRequest.builder()
                .title("산책 갈 사람")
                .recruitPersonnel(2)
                .recruitGenderType("male")
                .build();

        // when //then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/v1/board")
                                .content(objectMapper.writeValueAsString(boardAppendRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("내용 입력은 필수 입니다."))
                .andExpect(jsonPath("$.data").isEmpty())
        ;
    }

    @DisplayName("신규 게시판을 등록할 때 성별 입력은 필수 값이다")
    @Test
    void createBoardWithOutGenderType() throws Exception {
        // given
        BoardAppendRequest boardAppendRequest = BoardAppendRequest.builder()
                .title("짧산 ㄱㄱ")
                .content("나랑 산책 갈 남자만 구해요")
                .recruitPersonnel(2)
                .build();

        // when //then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/v1/board")
                                .content(objectMapper.writeValueAsString(boardAppendRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("성별 입력은 필수 입니다."))
                .andExpect(jsonPath("$.data").isEmpty())
        ;
    }

    @DisplayName("신규 게시판을 등록할 때 인원은 양수여야 한다")
    @Test
    void createBoardWithOutPersonnel() throws Exception {
        // given
        BoardAppendRequest boardAppendRequest = BoardAppendRequest.builder()
                .title("산책 가실분")
                .content("나랑 산책 갈 남자만 구해요")
                .recruitPersonnel(0)
                .recruitGenderType("male")
                .build();

        // when //then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/v1/board")
                                .content(objectMapper.writeValueAsString(boardAppendRequest))
                                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(400))
                .andExpect(jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(jsonPath("$.message").value("인원 수는 양수여야 합니다."))
                .andExpect(jsonPath("$.data").isEmpty())
        ;
    }

    @DisplayName("게시판을 조회한다.")
    @Test
    void getFindBoard() throws Exception {
        // given
        List<BoardQueryResponse> boardQueryResponses = List.of();
        when(boardSearchService.findAllRecruitGenderTypeByBoard()).thenReturn(boardQueryResponses);

        // when //then
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/v1/board/{seq}", 1)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200))
                .andExpect(jsonPath("$.status").value("OK"))
                .andExpect(jsonPath("$.message").value("OK"))
                .andExpect(jsonPath("$.data").isArray())
        ;
    }



}