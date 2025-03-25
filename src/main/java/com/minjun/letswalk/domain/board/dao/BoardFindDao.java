package com.minjun.letswalk.domain.board.dao;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardFindDao extends JpaRepository<BoardEntity, Long> {

    List<BoardEntity> findByBoardRecruitGenderType(BoardRecruitGenderType boardRecruitGenderType);
}
