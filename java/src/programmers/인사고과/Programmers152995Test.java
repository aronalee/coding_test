package programmers.인사고과;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers152995Test {

    private static Stream<Arguments> normalTestCases() {
        return Stream.of(
            Arguments.of(
                new int[][]{
                    {2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}
                },
                4
            ), Arguments.of(
                new int[][]{
                    {2, 2}, {1, 4}, {3, 2}, {3, 2}, {4, 5}
                },
                -1
            ), Arguments.of(
                new int[][]{
                    {0, 0}
                },
                1
            ), Arguments.of(
                new int[][]{
                    {2, 2}, {3, 3}, {1, 100_000}, {100_000, 1}
                },
                -1
            )
        );
    }

    @ParameterizedTest
    @MethodSource("normalTestCases")
    void normalTest(final int[][] score, final int answer) {
        Solution solution = new Solution();
        int result = solution.solution(score);
        assertThat(result).isEqualTo(answer);
    }
}