package com.minjun.letswalk.domain.board;

import java.util.List;

public interface BoardQueryRepository {
    List<BoardEntity> findAllByRecruitGenderTypeIn(List<BoardRecruitGenderType> boardRecruitGenderTypes);

}
