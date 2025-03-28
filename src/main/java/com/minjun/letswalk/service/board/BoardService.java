package com.minjun.letswalk.service.board;

import com.minjun.letswalk.domain.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardAppender boardAppender;

    public Long save(BoardSaveCommend boardSaveCommend) {
        BoardTitle boardTitle = BoardTitle.of(boardSaveCommend.title());
        BoardContent boardContent = BoardContent.of(boardSaveCommend.content());
        BoardRecruitGenderType boardRecruitGenderType = boardSaveCommend.boardRecruitGenderType();
        Integer boardRecruitPersonnel = boardSaveCommend.boardRecruitPersonnel();

        BoardEntity boardEntity = BoardEntity.of(
                boardTitle,
                boardContent,
                boardRecruitGenderType,
                boardRecruitPersonnel
        );

        return boardAppender.append(boardEntity);
    }

}
