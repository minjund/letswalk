package com.minjun.letswalk.domain.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TitleTest {

    @DisplayName("제목 객체를 생성 한 값을 확인 한다.")
    @Test
    void getName() {
        Title title = new Title("아아");

        assertThat(title.valueOf()).isEqualTo("아아");
    }

    @DisplayName("제목 길이가 20자를 넘어 갈 수 없다.")
    @Test
    void lengthCheck() {
        assertThatThrownBy(() -> {
            new Title("1234567890123456789011");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("20자 이상 제목을 입력할 수 없습니다.");
    }
}