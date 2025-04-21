package com.minjun.letswalk.service.board;

import com.minjun.letswalk.domain.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardAppender boardAppender;

    public Long boardSave(BoardSaveCommand boardSaveCommand) {
        BoardTitle boardTitle = BoardTitle.of(boardSaveCommand.title());
        BoardContent boardContent = BoardContent.of(boardSaveCommand.content());
        BoardRecruitGenderType boardRecruitGenderType = boardSaveCommand.boardRecruitGenderType();
        BoardRecruitAgeType boardRecruitAgeType = boardSaveCommand.recruitAge();

        BoardEntity boardEntity = BoardEntity.of(
                boardTitle,
                boardContent,
                boardRecruitGenderType,
                boardSaveCommand.boardRecruitPersonnel(),
                boardRecruitAgeType,
                boardSaveCommand.recruitAddress(),
                boardSaveCommand.recruitLocalDateTime()

        );

        return boardAppender.append(boardEntity);
    }



}
