package com.minjun.letswalk.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @DisplayName("게시판을 생성한다.")
    @Test
    void test(){
        // given
        BoardSaveCommand boardSaveCommand = new BoardSaveCommand(
                "산책",
                "가자",
                BoardRecruitGenderType.EVERY,
                1,
                "every",
                "삼성동",
                LocalDateTime.now()
        );

        // when
        Board board = Board.of(boardSaveCommand);

        // then
        assertThat(board.boardContent().value()).isEqualTo("가자");
    }
}