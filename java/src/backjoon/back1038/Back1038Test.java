// prob https://www.acmicpc.net/problem/1038

package backjoon.back1038;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1038Test {

    public static Stream<Arguments> backjoonNormalTestCases() {
        return Stream.of(
            Arguments.of(18, "42"),
            Arguments.of(0, "0")
        );
    }

    public static Stream<Arguments> backjoonThrowExceptionCases() {
        return Stream.of(
            Arguments.of(500000)
        );
    }

    @MethodSource("backjoonNormalTestCases")
    @ParameterizedTest
    void givenNormalCase_whenExecute_thenSuccess(int n, String answer) {
        Back1038 back1038 = new Back1038();
        String result = back1038.getDescNumberAboutN(n);
        assertThat(result).isEqualTo(answer);
    }

    @MethodSource("backjoonThrowExceptionCases")
    @ParameterizedTest
    void givenExceptionCase_whenExecute_thenThrowException(int n) {
        Back1038 back1038 = new Back1038();
        assertThatThrownBy(() -> back1038.getDescNumberAboutN(n))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Over N");
    }
}