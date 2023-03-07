// prob: https://school.programmers.co.kr/learn/courses/30/lessons/64062

package programmers.징검다리_건너기;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers64062Test {

    public static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(
                new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3, 3
            )
        );
    }

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(
                IntStream.range(0, 200000).map(v -> 1).toArray(), 1, 1
            ),
            Arguments.of(
                new int[]{200000000, 2}, 1, 2
            ),
            Arguments.of(
                IntStream.range(1, 200000).toArray(), 1, 1
            ),
            Arguments.of(
                new int[]{200000000}, 1, 200000000
            ),
            Arguments.of(
                new int[]{200000000}, 1, 200000000
            ),
            Arguments.of(
                new int[]{7, 9, 2, 3, 5, 6, 8, 10}, 2, 3
            ),
            Arguments.of(
                IntStream.range(1, 200001).map(v -> {
                    if (v == 200000) {
                        return 200000;
                    }
                    return 1;
                }).toArray(), 200000, 200000
            )
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void solution(int[] stones, int k, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(stones, k);
        assertThat(result).isEqualTo(answer);
    }
}