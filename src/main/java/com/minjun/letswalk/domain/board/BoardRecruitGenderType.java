package com.minjun.letswalk.domain.board;

import com.minjun.letswalk.domain.converter.AbstractCodedEnumConverter;
import com.minjun.letswalk.domain.converter.CodedEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum BoardRecruitGenderType implements CodedEnum<String> {
    FEMALE("female"),
    MALE("male"),
    EVERY("every");

    private final String code;

    public static List<BoardRecruitGenderType> forDisplay() {
        return List.of(FEMALE, MALE, EVERY);
    }

    @jakarta.persistence.Converter(autoApply = true)
    static class Converter extends AbstractCodedEnumConverter<BoardRecruitGenderType, String> {
        public Converter() {
            super(BoardRecruitGenderType.class);
        }
    }

    public static BoardRecruitGenderType findByCode(String code){
        for(BoardRecruitGenderType value : values()){
            if(value.getCode().equals(code)){
                return value;
            }
        }
        throw new IllegalArgumentException("모집 성별 코드를 찾을 수 없습니다.");
    }
}
