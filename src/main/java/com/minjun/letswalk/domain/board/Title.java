package com.minjun.letswalk.domain.board;

public record Title(String title) {
    public Title {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank");
        }
    }

    public static Title of(String value) {
        return new Title(value);
    }

    public String valueOf(){
        return title;
    }
}
