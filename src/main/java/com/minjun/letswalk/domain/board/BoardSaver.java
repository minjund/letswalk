package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.domain.board.dao.BoardDao;
import com.minjun.letswalk.service.board.BoardSaveCommend;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardSaver {
    private final BoardDao boardDao;

    public Long save(BoardSaveCommend boardSaveCommend){
        BoardEntity boardEntity = BoardEntity.save(boardSaveCommend);

        BoardEntity save = boardDao.save(boardEntity);

        return save.getBoardSeq();
    }
}
