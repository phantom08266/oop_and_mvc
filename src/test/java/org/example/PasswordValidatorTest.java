package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PasswordValidatorTest {
    @Test
    @DisplayName("비밀번호가 최소 8자 이상 12자 이하이면 예외가 발생하지 않는다.")
    void validatePasswordTest() {

        assertThatCode(() ->PasswordValidator.validate("servicetest"))
                .doesNotThrowAnyException();
    }

    //경계값 테스트
    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})
    void validatePasswordTest2(String password) {
        assertThatCode(() -> PasswordValidator.validate(password))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
