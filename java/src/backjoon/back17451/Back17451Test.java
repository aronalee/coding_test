// prob: https://www.acmicpc.net/problem/17451

package backjoon.back17451;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back17451Test {


    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(300L, 400L, 500L, 400L, 300L), 900)
        );
    }

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(Arrays.asList(300L, 400L, 500L, 11L, 300L), 900),
            Arguments.of(Arrays.asList(300L, 400L, 500L, 299L, 300L), 1200),
            Arguments.of(List.of(3000L), 3000),
            Arguments.of(List.of(1L), 1)
        );
    }

    @MethodSource({"backjoonTestCases", "customTestCases"})
    @ParameterizedTest
    void givenSpeeds_WhenGetAnswer_ThenAnswer(List<Long> speeds, long answer) {
        Back17451 back17451 = new Back17451();
        long result = back17451.getAnswer(speeds);
        assertThat(result)
            .isEqualTo(answer);
    }
}