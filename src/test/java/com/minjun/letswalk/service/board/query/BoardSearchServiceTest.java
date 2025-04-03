package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.domain.board.BoardContent;
import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardTitle;
import com.minjun.letswalk.infra.dao.BoardFindJpaRepository;
import com.minjun.letswalk.infra.dao.BoardJpaRepository;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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
                1
        );

        BoardEntity boardEntity1 = BoardEntity.of(
                BoardTitle.of("산책 갈 사람?"),
                BoardContent.of("여자만.."),
                BoardRecruitGenderType.FEMALE,
                2
        );

        BoardEntity boardEntity2 = BoardEntity.of(
                BoardTitle.of("산책 갈 사람?"),
                BoardContent.of("여자만..좀요"),
                BoardRecruitGenderType.FEMALE,
                2
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