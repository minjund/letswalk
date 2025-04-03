package com.minjun.letswalk.domain.board;

import lombok.Builder;

@Builder
public record BoardSaveCommand(String title,
                               String content,
                               BoardRecruitGenderType boardRecruitGenderType,
                               Integer boardRecruitPersonnel
) {
}
