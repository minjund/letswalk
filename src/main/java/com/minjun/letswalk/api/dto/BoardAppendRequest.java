package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardSaveCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public record BoardAppendRequest(
        @NotBlank(message = "제목 입력은 필수 입니다.")
        String title,
        @NotBlank(message = "내용 입력은 필수 입니다.")
        String content,
        @NotBlank(message = "성별 입력은 필수 입니다.")
        String boardRecruitGenderType,
        @Positive(message = "인원 수는 양수여야 합니다.")
        Integer boardRecruitPersonnel) {

    public BoardSaveCommand toCommand() {
        return new BoardSaveCommand(
                title,
                content,
                BoardRecruitGenderType.findByCode(boardRecruitGenderType),
                boardRecruitPersonnel
        );
    }
}
