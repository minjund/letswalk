package com.minjun.letswalk.domain.board;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardAppender {
    private final BoardRepository boardRepository;

    public Long append(BoardEntity boardEntity){
        BoardEntity save = boardRepository.save(boardEntity);

        return save.getBoardSeq();
    }
}
