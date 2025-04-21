package com.minjun.letswalk.api.dto;

import com.minjun.letswalk.domain.board.BoardRecruitAgeType;
import com.minjun.letswalk.domain.board.BoardRecruitGenderType;
import com.minjun.letswalk.domain.board.BoardSaveCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardAppendRequest(
        @NotBlank(message = "제목 입력은 필수 입니다.")
        String title,
        @NotBlank(message = "내용 입력은 필수 입니다.")
        String content,
        @NotBlank(message = "성별 입력은 필수 입니다.")
        String recruitGenderType,
        @Positive(message = "인원 수는 양수여야 합니다.")
        Integer recruitPersonnel,
        @NotBlank(message = "인원 입력은 필수 입니다.")
        String recruitAge,
        @NotBlank(message = "모집 주소는 필수 입니다.")
        String recruitAddress,
        @NotNull
        LocalDateTime recruitLocalDateTime
) {

    public BoardSaveCommand toCommand() {
        return new BoardSaveCommand(
                title,
                content,
                BoardRecruitGenderType.findByCode(recruitGenderType),
                recruitPersonnel,
                BoardRecruitAgeType.findByCode(recruitAge),
                recruitAddress,
                recruitLocalDateTime
        );
    }
}
