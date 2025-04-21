package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.infra.dao.BoardFindJpaRepository;
import com.minjun.letswalk.infra.dao.BoardJpaRepository;
import jakarta.transaction.Transactional;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class BoardQueryDaoTest {

    @Autowired
    private BoardJpaRepository boardJpaRepository;

    @Autowired
    private BoardFindJpaRepository boardFindJpaRepository;

    @AfterEach
    void tearDown() {
        boardJpaRepository.deleteAllInBatch();
        boardFindJpaRepository.deleteAllInBatch();
    }

    @DisplayName("원하는 상태를 가진 게시판을 조회한다.")
    @Test
    void boardSearch(){
        // given
        BoardTitle boardTitle = BoardTitle.of("산책 가실 분?");
        BoardContent content = BoardContent.of("점심시간 짧게 다녀와볼 사람");
        BoardEntity boardEntity = BoardEntity.of(
                boardTitle,
                content,
                BoardRecruitGenderType.FEMALE,
                3,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()
        );
        BoardEntity boardEntity2 = BoardEntity.of(
                boardTitle,
                content,
                BoardRecruitGenderType.MALE,
                3,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()
        );
        BoardEntity boardEntity3 = BoardEntity.of(
                boardTitle,
                content,
                BoardRecruitGenderType.ANY,
                3,
                BoardRecruitAgeType.ADULT,
                "삼성동",
                LocalDateTime.now()
        );
        boardJpaRepository.saveAll(List.of(boardEntity,boardEntity2,boardEntity3));

        // when
        List<BoardEntity> allByRecruitGenderTypeIn = boardFindJpaRepository.findAllByRecruitGenderTypeIn(List.of(BoardRecruitGenderType.FEMALE));

        // then
        assertThat(allByRecruitGenderTypeIn)
                .hasSize(1)
                .extracting("title", "content", "recruitGenderType")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(
                                "산책 가실 분?",
                                "점심시간 짧게 다녀와볼 사람",
                                BoardRecruitGenderType.FEMALE
                        )
                );

    }



}