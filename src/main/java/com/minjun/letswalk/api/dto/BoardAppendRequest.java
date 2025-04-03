package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardSaveCommand;

public record BoardAppendRequest(String title,
                                 String content,
                                 String boardRecruitGenderType,
                                 Integer boardRecruitPersonnel) {

    public BoardSaveCommand toCommand() {
        return new BoardSaveCommand(
                title,
                content,
                BoardRecruitGenderType.findByCode(boardRecruitGenderType),
                boardRecruitPersonnel
        );
    }
}
