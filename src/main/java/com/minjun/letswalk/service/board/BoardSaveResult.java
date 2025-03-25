package com.minjun.letswalk.service.board;

public record BoardSaveResult(Long boardSeq) {
    public static BoardSaveResult of(Long boardSeq) {
        return new BoardSaveResult(boardSeq);
    }
}
