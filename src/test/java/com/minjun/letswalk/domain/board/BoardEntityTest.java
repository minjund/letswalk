package com.minjun.letswalk.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardEntityTest {

    @DisplayName("보드 엔티티가 생성 되는지 확인한다.")
    @Test
    void boarEntityCreate(){
        // given
        BoardTitle boardTitle = BoardTitle.of("산책 갈 사람?");
        BoardContent boardContent = BoardContent.of("남자만..");
        BoardRecruitGenderType boardRecruitGenderType = BoardRecruitGenderType.MALE;
        Integer boardRecruitPersonnel = 2;

        // when
        BoardEntity boardEntity = BoardEntity.of(boardTitle, boardContent, boardRecruitGenderType, boardRecruitPersonnel);

        // then
        assertThat(boardEntity.getTitle())
                .isEqualTo("산책 갈 사람?");

        assertThat(boardEntity.getContent())
                .isEqualTo("남자만..");
    }

}