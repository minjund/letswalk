package com.minjun.letswalk.domain.board;

import java.util.List;

public interface BoardQueryDao {
    List<BoardEntity> findAllByRecruitGenderTypeIn(List<BoardRecruitGenderType> boardRecruitGenderTypes);

}
