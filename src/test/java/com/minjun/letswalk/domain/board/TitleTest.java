package com.minjun.letswalk.domain.board;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class TitleTest {

    @Test
    void getName() {
        Title title = new Title("아아");

        assertThat(title.valueOf()).isEqualTo("아아");
    }

    @Test
    void lengthCheck() {
        assertThatThrownBy(() -> {
            new Title("12345678901234567890");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("20자 이상 제목을 입력할 수 없습니다.");
    }
}