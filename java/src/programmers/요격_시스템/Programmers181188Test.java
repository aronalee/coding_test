// prob: https://school.programmers.co.kr/learn/courses/30/lessons/181188

package programmers.요격_시스템;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers181188Test {


    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {1, 100}, {2, 3}, {3, 4}, {4, 5}
            }, 3)
        );
    }

    public static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {4, 5}, {4, 8},
                {10, 14}, {11, 13},
                {5, 12}, {3, 7}, {1, 4}
            }, 3)
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void givenTargets_WhenSolution_GetExpected(
        int[][] targets,
        int expected
    ) {
        // given
        Solution solution = new Solution();
        // when
        int actual = solution.solution(targets);
        // then
        assertThat(actual).isEqualTo(expected);
    }
}