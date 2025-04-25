package com.minjun.letswalk.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardAppender {
    private final BoardDao boardDao;

    public String append(BoardEntity boardEntity){
        BoardEntity save = boardDao.save(boardEntity);
        return save.getId();
    }
}
