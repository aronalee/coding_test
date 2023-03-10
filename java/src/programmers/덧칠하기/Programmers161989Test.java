// prob: https://school.programmers.co.kr/learn/courses/30/lessons/161989

package programmers.덧칠하기;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers161989Test {

    public static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(8, 4, new int[]{2, 3, 6}, 2),
            Arguments.of(5, 4, new int[]{1, 3}, 1),
            Arguments.of(4, 1, new int[]{1, 2, 3, 4}, 4)
        );
    }

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(1, 1, new int[]{1}, 1),
            Arguments.of(100000, 1, IntStream.rangeClosed(1, 100000).toArray(), 100000),
            Arguments.of(100000, 1, IntStream
                    .iterate(2, (v) -> v + 2).limit(100000)
                    .toArray(),
                50000),
            Arguments.of(100000, 100000, IntStream.rangeClosed(1, 100000).toArray(), 1),
            Arguments.of(100000, 100000, new int[]{50000}, 1)
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    void solution(int n, int m, int[] section, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(n, m, section);
        assertThat(result).isEqualTo(answer);
    }
}