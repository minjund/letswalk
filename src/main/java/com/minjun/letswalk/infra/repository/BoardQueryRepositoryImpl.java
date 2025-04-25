package com.minjun.letswalk.infra.repository;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.minjun.letswalk.domain.board.QBoardEntity.boardEntity;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepositoryImpl implements BoardQueryRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<BoardEntity> findBoardsByGenderTypes(List<BoardRecruitGenderType> genderTypes) {
        return queryFactory.selectFrom(boardEntity)
                .where(boardEntity.recruitGenderType.in(genderTypes))
                .orderBy(boardEntity.createDateTime.desc())
                .fetch();
    }
}
