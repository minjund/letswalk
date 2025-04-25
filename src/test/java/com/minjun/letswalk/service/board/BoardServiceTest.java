package com.minjun.letswalk.service.board;

import com.minjun.letswalk.api.dto.BoardAppendRequest;
import com.minjun.letswalk.infra.dao.BoardJpaRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    BoardJpaRepository boardJpaRepository;

    @DisplayName("게시판 정보를 받아 게시판을 생성한다.")
    @Test
    void boardCreate(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest(
                "ㅇㅇ",
                "점심 시간 짧게 ㄱㄱ",
                "male",
                3,
                "all",
                "삼성동",
                LocalDateTime.now()
        );

        // when
        String saveSeq = boardService.boardSave(boardAppendRequest.toCommand());

        // then
        assertThat(saveSeq).isNotNull();
    }
}