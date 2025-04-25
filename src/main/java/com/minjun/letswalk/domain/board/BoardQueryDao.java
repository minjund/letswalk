package com.minjun.letswalk.domain.board;

import java.util.List;

public interface BoardQueryDao {
    List<BoardEntity> findBoardsByGenderTypes(List<BoardRecruitGenderType> boardRecruitGenderTypes);
}
