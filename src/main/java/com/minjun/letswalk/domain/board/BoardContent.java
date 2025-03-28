package com.minjun.letswalk.domain.board;

public record BoardContent(String value) {
    public BoardContent {
        if (value == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
    }

    public static BoardContent of(String content) {
        return new BoardContent(content);
    }
}

