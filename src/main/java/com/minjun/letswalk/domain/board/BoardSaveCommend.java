package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.api.dto.BoardSaveRequest;
import lombok.Builder;

@Builder
public record BoardSaveCommend(String title,
                               String content,
                               BoardRecruitGenderType boardRecruitGenderType,
                               Integer boardRecruitPersonnel
) {
}
