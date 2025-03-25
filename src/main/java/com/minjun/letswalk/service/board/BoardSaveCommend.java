package com.minjun.letswalk.service.board;

import com.minjun.letswalk.api.dto.BoardRequest;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardRecruitPersonnel;
import com.minjun.letswalk.domain.board.Content;
import com.minjun.letswalk.domain.board.Title;
import lombok.Builder;

@Builder
public record BoardSaveCommend(Title title,
                               Content content,
                               BoardRecruitGenderType boardRecruitGenderType,
                               BoardRecruitPersonnel boardRecruitPersonnel
) {
    public static BoardSaveCommend from(BoardRequest boardRequest) {
        return BoardSaveCommend.builder()
                .title(Title.of(boardRequest.title()))
                .content(Content.of(boardRequest.content()))
                .boardRecruitGenderType(BoardRecruitGenderType.of(boardRequest.boardRecruitGenderType()))
                .boardRecruitPersonnel(BoardRecruitPersonnel.of(boardRequest.boardRecruitPersonnel()))
                .build();
    }
}
