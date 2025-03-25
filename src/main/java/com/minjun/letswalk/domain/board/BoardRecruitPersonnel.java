package com.minjun.letswalk.domain.board;

public record BoardRecruitPersonnel(Integer personCount) {
    public BoardRecruitPersonnel {
        if (personCount == null || personCount <= 0) {
            throw new IllegalArgumentException("BoardRecruitPersonnel must be positive");
        }
    }

    public static BoardRecruitPersonnel of(Integer value) {
        return new BoardRecruitPersonnel(value);
    }

    public Integer valueOf(){
        return personCount;
    }
}

