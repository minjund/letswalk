package com.minjun.letswalk.service.board;

import com.minjun.letswalk.domain.board.BoardSaver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardSaver boardSaver;

    public BoardSaveResult save(BoardSaveCommend boardSaveCommend) {
        Long boardSeq = boardSaver.save(boardSaveCommend);

        return BoardSaveResult.of(boardSeq);
    }

}
