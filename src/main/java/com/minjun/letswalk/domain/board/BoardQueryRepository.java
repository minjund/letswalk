package com.minjun.letswalk.domain.board;

import java.util.List;

public interface BoardQueryRepository {
    List<BoardEntity> findByBoardRecruitGenderType(BoardRecruitGenderType boardRecruitGenderType);

}
