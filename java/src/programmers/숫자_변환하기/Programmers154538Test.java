// prob: https://school.programmers.co.kr/learn/courses/30/lessons/154538

package programmers.숫자_변환하기;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers154538Test {

    private static Stream<Arguments> getNormalTestCases() {
        return Stream.of(
            Arguments.of(new int[]{10, 40, 5}, 2),
            Arguments.of(new int[]{10, 40, 30}, 1),
            Arguments.of(new int[]{2, 5, 4}, -1),
            Arguments.of(new int[]{1, 1000000, 1}, 19)
        );
    }

    private static Stream<Arguments> getMinTestCases() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 1}, 0),
            Arguments.of(new int[]{1, 2, 3}, 1),
            Arguments.of(new int[]{1, 3, 4}, 1),
            Arguments.of(new int[]{1, 4, 3}, 1)
        );
    }

    private static Stream<Arguments> getMaxTestCases() {
        return Stream.of(
            Arguments.of(new int[]{999999, 1000000, 2}, -1),
            Arguments.of(new int[]{999999, 1000000, 1}, 1),
            Arguments.of(new int[]{999999, 1000000, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource({"getNormalTestCases", "getMinTestCases", "getMaxTestCases"})
    void solution(final int[] parameters, final int answer) {
        // give
        int x = parameters[0];
        int y = parameters[1];
        int n = parameters[2];
        // when
        Solution solution = new Solution();
        int result = solution.solution(x, y, n);
        // then
        assertThat(result).isEqualTo(answer);
    }
}