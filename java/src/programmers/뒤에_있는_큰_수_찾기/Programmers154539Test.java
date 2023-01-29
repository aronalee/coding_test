package programmers.뒤에_있는_큰_수_찾기;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers154539Test {

    private static Stream<Arguments> getTestCases() {
        return Stream.of(
            Arguments.of(
                new int[]{2, 3, 3, 5},
                new int[]{3, 5, 5, -1}
            ),
            Arguments.of(
                new int[]{9, 1, 5, 3, 6, 2},
                new int[]{-1, 5, 6, 6, -1, -1}
            ), Arguments.of(
                new int[]{1},
                new int[]{-1}
            )
        );
    }

    private static Stream<Arguments> getMinTestCases() {
        return Stream.of(
            Arguments.of(
                new int[]{1},
                new int[]{-1}
            )
        );
    }

    private static Stream<Arguments> getMaxTestCases() {
        return Stream.of(
            Arguments.of(
                IntStream.rangeClosed(1, 1000000).toArray(),
                IntStream.rangeClosed(1, 1000000).map(v -> {
                        if (v == 1000000) {
                            return -1;
                        }
                        return v + 1;
                    }
                ).toArray()
            ), Arguments.of(
                IntStream.range(0, 1000000).map(v -> 1000000 - v).toArray(),
                IntStream.iterate(-1, i -> i).limit(1000000).toArray()
            )
        );
    }

    @ParameterizedTest
    @MethodSource({"getTestCases", "getMinTestCases", "getMaxTestCases"})
    void solution(final int[] numbers, final int[] answer) {
        Solution solution = new Solution();
        int[] result = solution.solution(numbers);
        assertThat(result).isEqualTo(answer);
    }
}