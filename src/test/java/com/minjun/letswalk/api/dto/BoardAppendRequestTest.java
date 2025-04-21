package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardRecruitAgeType;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardSaveCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardAppendRequestTest {

    @DisplayName("게시판 요청 데이터를 저장 데이터로 변환한다.")
    @Test
    void boardRequestToCommand(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest(
                "산책",
                "좋아 하는 사람?",
                "male",
                1,
                "adult",
                "삼성동",
                LocalDateTime.of(2025,4,21,10,47)
        );

        // when
        BoardSaveCommand command = boardAppendRequest.toCommand();

        // then
        assertThat(command.title()).isEqualTo("산책");
        assertThat(command.content()).isEqualTo("좋아 하는 사람?");
        assertThat(command.boardRecruitGenderType()).isEqualTo(BoardRecruitGenderType.MALE);
        assertThat(command.boardRecruitPersonnel()).isEqualTo(1);
        assertThat(command.recruitAddress()).isEqualTo("삼성동");
        assertThat(command.recruitAge()).isEqualTo(BoardRecruitAgeType.ADULT);
        assertThat(command.recruitLocalDateTime()).isEqualTo(LocalDateTime.of(2025,4,21,10,47));
    }

    @DisplayName("게시판 요청 데이터를 저장 데이터로 변환에 실패한다.")
    @Test
    void FailBoardRequestToCommand(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest(
                "산책",
                "좋아 하는 사람?",
                "male2233",
                1,
                "any",
                "삼성동",
                LocalDateTime.of(2025,4,21,10,47));

        // when // then
        assertThatThrownBy(boardAppendRequest::toCommand)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("모집 성별 코드를 찾을 수 없습니다.");
    }
}