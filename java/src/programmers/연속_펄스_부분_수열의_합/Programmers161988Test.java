// prob: https://school.programmers.co.kr/learn/courses/30/lessons/161988

package programmers.연속_펄스_부분_수열의_합;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers161988Test {

    private static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, -6, 1, 3, -1, 2, 4}, 10)
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(new int[]{100000}, 100000),
            Arguments.of(new int[]{1, -1, 1, -1}, 4),
            Arguments.of(new int[]{-1, -1, -1, -1}, 1),
            Arguments.of(new int[]{1, -100, 3, -400, 5, 1000}, 1000),
            Arguments.of(IntStream.rangeClosed(1, 500000).map(v -> 100000).toArray(),
                100000)
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void solution(int[] sequence, long answer) {
        Solution solution = new Solution();
        long result = solution.solution(sequence);
        assertThat(result).isEqualTo(answer);
    }
}