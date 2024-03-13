// prob: https://www.acmicpc.net/problem/19949

package backjoon.back19949;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back19949Test {

    public static Stream<Arguments> provideBack19949TestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 1, 2, 3, 4, 5), 261622),
                Arguments.of(List.of(5, 5, 5, 5, 5, 5, 5, 5, 5, 5), 137792)
        );
    }

    @MethodSource("provideBack19949TestCases")
    @ParameterizedTest
    void givenAnswers_whenCountAllCases_thenReturnsCount(List<Integer> answers, long count) {
        // given
        Back19949 back19949 = new Back19949(5);

        // when
        long actual = back19949.countAllCases(answers);

        // then
        assertThat(actual).isEqualTo(count);
    }
}