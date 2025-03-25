package com.minjun.letswalk.api.dto;

public record BoardRequest(String title,
                           String content,
                           String boardRecruitGenderType,
                           Integer boardRecruitPersonnel) {
}
