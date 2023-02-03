// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42884

package programmers.단속_카메라;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers42884Test {

    public static Stream<Arguments> normalTestCases() {
        return Stream.of(
            Arguments.of(
                new int[][]{
                    {-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}
                }, 2
            ),
            Arguments.of(
                new int[][]{
                    {-20, -15}, {-20, -14}, {-20, -13}, {-20, -12}, {-20, -11},
                }, 1
            ), Arguments.of(
                new int[][]{
                    {-20, 3000}, {1, 3}, {5, 7}, {9, 11}
                }, 3
            ),
            Arguments.of(
                new int[][]{
                    {1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}
                }, 5
            ), Arguments.of(
                new int[][]{
                    {1, 2}, {2, 3}, {3, 4}, {5, 6}, {7, 8}
                }, 4
            )
        );
    }

    public static Stream<Arguments> minTestCases() {
        return Stream.of(
            Arguments.of(
                new int[][]{
                    {0, 0}
                }, 1
            )
        );
    }

    public static Stream<Arguments> maxTestCases() {
        return Stream.of(
            Arguments.of(
                new int[][]{
                    {-30000, 30000}, {-30000, 30000}, {-30000, 30000}, {-30000, 30000}
                }, 1
            )
        );
    }

    @ParameterizedTest
    @MethodSource({"normalTestCases", "minTestCases", "maxTestCases"})
    void solution(int[][] routes, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(routes);
        assertThat(result).isEqualTo(answer);
    }
}