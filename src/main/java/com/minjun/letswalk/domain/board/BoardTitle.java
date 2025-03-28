package com.minjun.letswalk.domain.board;

public record BoardTitle(String value) {
    public BoardTitle {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("제목은 빈 값이 올 수 없습니다.");
        }

        if (value.length() > 20){
            throw new IllegalArgumentException("20자 이상 제목을 입력할 수 없습니다.");
        }
    }

    public static BoardTitle of(String value) {
        return new BoardTitle(value);
    }
}
