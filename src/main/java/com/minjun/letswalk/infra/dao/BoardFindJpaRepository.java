package com.minjun.letswalk.infra.dao;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardQueryDao;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardFindJpaRepository extends BoardQueryDao, JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findAllByRecruitGenderTypeIn(List<BoardRecruitGenderType> boardRecruitGenderTypes);
}
