package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.domain.converter.AbstractCodedEnumConverter;
import com.minjun.letswalk.domain.converter.CodedEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum BoardRecruitAgeType implements CodedEnum<String> {
    YOUTH("youth"),
    ADULT("adult"),
    ALL("all");

    private final String code;

    public static BoardRecruitAgeType findByCode(String code) {
        for(BoardRecruitAgeType value : values()){
            if(value.getCode().equalsIgnoreCase(code)){
                return value;
            }
        }

        throw new IllegalArgumentException("모집 성별 코드를 찾을 수 없습니다.");
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<BoardRecruitAgeType, String> {
        public Converter() {
            super(BoardRecruitAgeType.class);
        }
    }
}
