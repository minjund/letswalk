package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.domain.converter.AbstractCodedEnumConverter;
import com.minjun.letswalk.domain.converter.CodedEnum;
import lombok.Getter;

@Getter
public enum BoardRecruitGenderType implements CodedEnum<String> {
    FEMALE("female"),
    MALE("male"),
    EVERY("every");

    private final String code;

    BoardRecruitGenderType(String code) {
        this.code = code;
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<BoardRecruitGenderType, String> {
        public Converter() {
            super(BoardRecruitGenderType.class);
        }
    }
}
