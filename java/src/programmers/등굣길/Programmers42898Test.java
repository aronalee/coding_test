// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42898

package programmers.등굣길;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers42898Test {

    private static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(4, 3, new int[][]{
                {2, 2}
            }, 4)
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(3, 3,
                new int[][]{
                    {2, 1}, {2, 2}, {2, 3}
                }, 0
            ),
            Arguments.of(3, 3,
                new int[][]{}, 6
            ),
            Arguments.of(1, 2,
                new int[][]{}, 1
            ),
            Arguments.of(2, 1,
                new int[][]{}, 1
            ),
            Arguments.of(1, 100,
                new int[][]{}, 1
            )
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void solution(int m, int n, int[][] puddles, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(m, n, puddles);
        assertThat(result).isEqualTo(answer);
    }
}