package com.minjun.letswalk.infra.dao;

import com.minjun.letswalk.domain.board.BoardContent;
import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardTitle;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardFindJpaRepositoryTest {

    @Autowired
    BoardFindJpaRepository boardFindJpaRepository;

    @Autowired
    BoardJpaRepository boardJpaRepository;

    @DisplayName("특정 성별이 포함된 데이터를 읽어온다.")
    @Test
    void findGenderInBoard(){
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
        List<BoardRecruitGenderType> boardRecruitGenderTypeList = List.of(
                BoardRecruitGenderType.FEMALE
        );

        // when
        List<BoardEntity> boardEntityList = boardFindJpaRepository.findAllByRecruitGenderTypeIn(boardRecruitGenderTypeList);

        // then
        assertThat(boardEntityList).hasSize(2)
                .extracting("title", "content", "recruitGenderType")
                .containsExactlyInAnyOrder(
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


    @DisplayName("특정 성별이 포함된 데이터를 읽어올 때 반환 값이 없으면 빈 리스트를 반환한다.")
    @Test
    void findEmptyGenderBoard(){
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
        List<BoardRecruitGenderType> boardRecruitGenderTypeList = List.of(
                BoardRecruitGenderType.EVERY
        );

        // when
        List<BoardEntity> boardEntityList = boardFindJpaRepository.findAllByRecruitGenderTypeIn(boardRecruitGenderTypeList);

        // then
        assertThat(boardEntityList).isEmpty();
    }

}