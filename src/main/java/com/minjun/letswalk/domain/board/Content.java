package com.minjun.letswalk.domain.board;

public record Content(String content) {
    public Content {
        if (content == null) {
            throw new IllegalArgumentException("Content cannot be null");
        }
    }

    public static Content of(String content) {
        return new Content(content);
    }

    public String valueOf(){
        return content;
    }
}

