package com.minjun.letswalk.domain.board;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class BoardEntityTest {

    @DisplayName("보드 엔티티가 생성 되는지 확인한다.")
    @Test
    void boarEntityCreate(){
        // given
        BoardTitle boardTitle = BoardTitle.of("산책 갈 사람?");
        BoardContent boardContent = BoardContent.of("남자만..");
        BoardRecruitGenderType boardRecruitGenderType = BoardRecruitGenderType.MALE;
        BoardRecruitAgeType boardRecruitAgeType = BoardRecruitAgeType.ADULT;

        // when
        BoardEntity boardEntity = BoardEntity.of(
                boardTitle,
                boardContent,
                boardRecruitGenderType,
                2,
                boardRecruitAgeType,
                "삼성동",
                LocalDateTime.of(2025, 4, 21, 11, 13)
        );

        // then
        assertThat(boardEntity.getTitle())
                .isEqualTo("산책 갈 사람?");

        assertThat(boardEntity.getContent())
                .isEqualTo("남자만..");

        assertThat(boardEntity.getRecruitGenderType()).isEqualTo(BoardRecruitGenderType.MALE);
        assertThat(boardEntity.getRecruitAgeType()).isEqualTo(BoardRecruitAgeType.ADULT);
        assertThat(boardEntity.getRecruitAddress()).isEqualTo("삼성동");
    }

}