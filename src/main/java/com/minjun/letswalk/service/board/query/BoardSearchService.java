package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardQueryRepository;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardSearchService {

    private final BoardQueryRepository boardQueryRepository;

    public List<BoardEntity> find() {
        return boardQueryRepository.findByBoardRecruitGenderType(BoardRecruitGenderType.EVERY);
    }
}
