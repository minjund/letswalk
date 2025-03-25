package com.minjun.letswalk.service.board.query;

import com.minjun.letswalk.domain.board.BoardEntity;

import java.util.List;

public record BoardResult() {
    public static BoardResult of(List<BoardEntity> boardEntity) {
        return null;
    }
}
