package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardQueryDao;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardSearchService {

    private final BoardQueryDao boardQueryDao;

    public List<BoardQueryResponse> findAllRecruitGenderTypeByBoard() {
        List<BoardEntity> boardEntityList = boardQueryDao.findAllByRecruitGenderTypeIn(BoardRecruitGenderType.forDisplay());

        return boardEntityList.stream()
                .map(BoardQueryResponse::of)
                .toList();
    }
}
