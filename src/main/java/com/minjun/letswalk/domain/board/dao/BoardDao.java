package com.minjun.letswalk.domain.board.dao;

import com.minjun.letswalk.domain.board.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao extends JpaRepository<BoardEntity, Long> {
}
