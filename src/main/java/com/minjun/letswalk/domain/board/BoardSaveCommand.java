package com.minjun.letswalk.domain.board;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardSaveCommand(String title,
                               String content,
                               BoardRecruitGenderType boardRecruitGenderType,
                               Integer boardRecruitPersonnel,
                               BoardRecruitAgeType recruitAge,
                               String recruitAddress,
                               LocalDateTime recruitLocalDateTime
) {
}
