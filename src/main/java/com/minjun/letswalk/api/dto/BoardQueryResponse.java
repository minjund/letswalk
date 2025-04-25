package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardRecruitAgeType;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardQueryResponse(Long seq,
                                 String title,
                                 String content,
                                 BoardRecruitGenderType recruitGenderType,
                                 Integer recruitPersonnel,
                                 BoardRecruitAgeType boardRecruitAgeType,
                                 String recruitAddress,
                                 LocalDateTime recruitDateTime){

    public static BoardQueryResponse of(BoardEntity boardEntity) {
        return BoardQueryResponse.builder()
                .title(boardEntity.getTitle())
                .content(boardEntity.getContent())
                .recruitGenderType(boardEntity.getRecruitGenderType())
                .recruitPersonnel(boardEntity.getRecruitPersonnel())
                .boardRecruitAgeType(boardEntity.getRecruitAgeType())
                .recruitAddress(boardEntity.getRecruitAddress())
                .recruitDateTime(boardEntity.getRecruitDateTime())
                .build();
    }
}
