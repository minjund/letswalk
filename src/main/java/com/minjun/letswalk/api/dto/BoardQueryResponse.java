package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import lombok.Builder;

@Builder
public record BoardQueryResponse(Long seq,
                                 String title,
                                 String content,
                                 BoardRecruitGenderType recruitGenderType,
                                 Integer recruitPersonnel){

    public static BoardQueryResponse of(BoardEntity boardEntity) {
        return BoardQueryResponse.builder()
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .recruitGenderType(boardEntity.getRecruitGenderType())
                .recruitPersonnel(boardEntity.getRecruitPersonnel())
                .build();
    }
}
