package com.minjun.letswalk.domain.board;

import lombok.Builder;

@Builder
public record Board(BoardTitle boardTitle,
                    BoardContent boardContent,
                    BoardRecruitGenderType boardRecruitGenderType,
                    Integer boardRecruitPersonnel) {

    public static Board of(BoardSaveCommand boardSaveCommand) {
        return Board.builder()
                .boardTitle(BoardTitle.of(boardSaveCommand.title()))
                .boardContent(BoardContent.of(boardSaveCommand.content()))
                .boardRecruitGenderType(boardSaveCommand.boardRecruitGenderType())
                .boardRecruitPersonnel(boardSaveCommand.boardRecruitPersonnel())
                .build();
    }
}
