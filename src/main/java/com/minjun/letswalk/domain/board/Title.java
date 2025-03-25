package com.minjun.letswalk.domain.board;

public record Title(String title) {
    public Title {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }

        if (title.length() > 20){
            throw new RuntimeException("20자 이상 제목을 입력할 수 없습니다.");
        }
    }

    public static Title of(String value) {
        return new Title(value);
    }

    public String valueOf(){
        return title;
    }
}
