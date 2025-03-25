package com.minjun.letswalk.infra.dao;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardJpaDao extends BoardRepository, JpaRepository<BoardEntity, Long> {
}
