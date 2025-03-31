package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.api.dto.BoardAppendRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BoardRecruitGenderTypeTest {

    @DisplayName("저장 요청에 모집 성별 찾기에 성공한다.")
    @Test
    void boardRecruitGender(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest("산책 갈 사람","혼자예요..","male",3);

        // when
        BoardRecruitGenderType boardRecruitGenderType = BoardRecruitGenderType.findByCode(boardAppendRequest.boardRecruitGenderType());

        // then
        assertThat(boardRecruitGenderType.getCode()).isEqualTo("male");
    }

    @DisplayName("저장 요청에 모집 성별 찾기에 실패 하여 에러가 뜬다.")
    @Test
    void failFindBoardGender(){
        // given
        BoardAppendRequest boardAppendRequest = new BoardAppendRequest("산책 갈 사람22","혼자예요..22","male222",3);

        // when & then
        assertThatThrownBy(()-> {
                BoardRecruitGenderType.findByCode(boardAppendRequest.boardRecruitGenderType());        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("모집 성별 코드를 찾을 수 없습니다.");
    }

}