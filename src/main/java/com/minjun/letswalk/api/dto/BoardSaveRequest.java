package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardSaveCommend;

public record BoardSaveRequest(String title,
                               String content,
                               String boardRecruitGenderType,
                               Integer boardRecruitPersonnel) {

    public BoardSaveCommend toCommend() {
        return new BoardSaveCommend(
                title,
                content,
                BoardRecruitGenderType.findByCode(boardRecruitGenderType),
                boardRecruitPersonnel
        );
    }
}
