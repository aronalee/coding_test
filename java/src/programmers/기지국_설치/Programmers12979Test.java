// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12979

package programmers.기지국_설치;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers12979Test {

    private static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(11, new int[]{4, 11}, 1, 3),
            Arguments.of(16, new int[]{9}, 2, 3)
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(200000000, new int[]{2}, 1, 66666666),
            Arguments.of(1, new int[]{1}, 1, 0),
            Arguments.of(100, new int[]{1}, 10000, 0),
            Arguments.of(11, new int[]{2, 5, 9}, 1, 2)
        );
    }


    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void solution(int n, int[] stations, int w, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(n, stations, w);
        assertThat(result).isEqualTo(answer);
    }
}