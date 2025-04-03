package com.minjun.letswalk.service.board;

import com.minjun.letswalk.api.dto.BoardAppendRequest;
import com.minjun.letswalk.infra.dao.BoardJpaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    BoardJpaRepository boardJpaRepository;

    @DisplayName("게시판 정보를 받아 게시판을 생성한다.")
    @Test
    void booardCreate(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest(
                "ㅇㅇ",
                "점심 시간 짧게 ㄱㄱ",
                "male",
                3
        );

        // when
        Long saveSeq = boardService.save(boardAppendRequest.toCommend());

        // then
        assertThat(saveSeq).isNotNull().isEqualTo(1L);
    }
}