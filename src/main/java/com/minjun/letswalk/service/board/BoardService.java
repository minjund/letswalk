package com.minjun.letswalk.service.board;

import com.minjun.letswalk.domain.board.BoardEntity;
import com.minjun.letswalk.domain.board.BoardAppender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardAppender boardAppender;

    public BoardSaveResult save(BoardSaveCommend boardSaveCommend) {
        BoardEntity boardEntity = BoardEntity.of(boardSaveCommend);

        Long boardSeq = boardAppender.append(boardEntity);

        return BoardSaveResult.of(boardSeq);
    }

}
