package com.minjun.letswalk.domain.board;

public record Title(String title) {
    public Title {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("제목은 빈 값이 올 수 없습니다.");
        }

        if (title.length() > 20){
            throw new IllegalArgumentException("20자 이상 제목을 입력할 수 없습니다.");
        }
    }

    public static Title of(String value) {
        return new Title(value);
    }

    public String valueOf(){
        return title;
    }
}
