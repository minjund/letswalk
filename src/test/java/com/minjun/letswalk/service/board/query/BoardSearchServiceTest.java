package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.domain.board.*;
import com.minjun.letswalk.infra.dao.BoardFindJpaRepository;
import com.minjun.letswalk.infra.dao.BoardJpaRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoardSearchServiceTest {

    @Autowired
    private BoardSearchService boardSearchService;

    @Autowired
    BoardFindJpaRepository boardFindJpaRepository;

    @Autowired
    BoardJpaRepository boardJpaRepository;

    @DisplayName("보드 서비스 단에서 특정 성별이 포함된 데이터를 읽어온다.")
    @Test
    void findAllRecruitGenderTypeByBoardGenderInBoard(){
        // given
        BoardTitle boardTitle = BoardTitle.of("산책 갈 사람?");
        BoardContent boardContent = BoardContent.of("남자만..");

        BoardEntity boardEntity = BoardEntity.of(
                boardTitle,
                boardContent,
                BoardRecruitGenderType.MALE,
                1,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()

        );

        BoardEntity boardEntity1 = BoardEntity.of(
                BoardTitle.of("산책 갈 사람?"),
                BoardContent.of("여자만.."),
                BoardRecruitGenderType.FEMALE,
                2,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()
        );

        BoardEntity boardEntity2 = BoardEntity.of(
                BoardTitle.of("산책 갈 사람?"),
                BoardContent.of("여자만..좀요"),
                BoardRecruitGenderType.FEMALE,
                2,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()
        );

        boardJpaRepository.saveAll(List.of(boardEntity,boardEntity1,boardEntity2));

        // when
        List<BoardQueryResponse> recruitGenderTypeByBoard = boardSearchService.findAllRecruitGenderTypeByBoard();

        // then
        assertThat(recruitGenderTypeByBoard).hasSize(3)
                .extracting("title", "content", "recruitGenderType")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(
                                "산책 갈 사람?",
                                "남자만..",
                                BoardRecruitGenderType.MALE
                        ),
                        Tuple.tuple(
                                "산책 갈 사람?",
                                "여자만..",
                                BoardRecruitGenderType.FEMALE
                        ),
                        Tuple.tuple(
                                "산책 갈 사람?",
                                "여자만..좀요",
                                BoardRecruitGenderType.FEMALE
                        )
                );
    }

}