package com.minjun.letswalk.domain.board;

import java.util.List;

public interface BoardQueryRepository{
    List<BoardEntity> findByBoardRecruitGenderTypeIn(List<BoardRecruitGenderType> boardRecruitGenderTypes);

}
