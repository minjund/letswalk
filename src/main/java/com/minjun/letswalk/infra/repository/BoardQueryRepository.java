package com.minjun.letswalk.infra.repository;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardQueryDao;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;

import java.util.List;

public interface BoardQueryRepository extends BoardQueryDao {
    List<BoardEntity> findBoardsByGenderTypes(List<BoardRecruitGenderType> genderTypes);
}
