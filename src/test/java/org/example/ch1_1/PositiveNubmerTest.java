package org.example.ch1_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositiveNubmerTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void positiveNumberTest(int value) {
        assertThatCode(() -> new PositiveNumber(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0또는 음수를 사용할 수 없습니다.");
    }
}
