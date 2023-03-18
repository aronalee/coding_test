// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12927

package programmers.야근_지수;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers12927Test {

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(
                IntStream.rangeClosed(1, 20000).map(v -> 1).toArray(),
                1,
                19999
            ),
            Arguments.of(
                IntStream.rangeClosed(1, 20000).map(v -> 1).toArray(),
                1000000,
                0
            ),
            Arguments.of(
                IntStream.rangeClosed(1, 20000).map(v -> 50000).toArray(),
                1,
                49999999900001L
            ), Arguments.of(
                IntStream.rangeClosed(1, 20000).map(v -> 50000).toArray(),
                1000000,
                49900050000000L
            )
        );
    }

    private static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(new int[]{4, 3, 3}, 4, 12),
            Arguments.of(new int[]{2, 1, 2}, 1, 6),
            Arguments.of(new int[]{1, 1}, 3, 0)
        );
    }


    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void givenArgsOfSolution_WhenSolution_ThenSuccess(int[] work, int n, long answer) {
        Solution solution = new Solution();
        long result = solution.solution(n, work);
        assertThat(result).isEqualTo(answer);
    }
}