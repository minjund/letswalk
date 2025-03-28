package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.api.dto.BoardQueryResponse;
import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardQueryRepository;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardSearchService {

    private final BoardQueryRepository boardQueryRepository;

    public List<BoardQueryResponse> find() {
        List<BoardEntity> boardEntityList = boardQueryRepository.findAllByRecruitGenderTypeIn(BoardRecruitGenderType.forDisplay());

        return boardEntityList.stream()
                .map(BoardQueryResponse::of)
                .collect(Collectors.toList());
    }
}
