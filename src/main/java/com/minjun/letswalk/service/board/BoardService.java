package com.minjun.letswalk.service.board;

import com.minjun.letswalk.domain.board.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardAppender boardAppender;

    public Long boardSave(BoardSaveCommand boardSaveCommand) {
        Board board = Board.of(boardSaveCommand);

        BoardEntity boardEntity = BoardEntity.of(
                board.boardTitle(),
                board.boardContent(),
                board.boardRecruitGenderType(),
                board.boardRecruitPersonnel()
        );

        return boardAppender.append(boardEntity);
    }



}
