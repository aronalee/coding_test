// prob: https://www.acmicpc.net/problem/1823

package backjoon.back1823;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1823Test {

    private static Stream<Arguments> normalCases() {
        return Stream.of(
            Arguments.of(List.of(1, 3, 1, 5, 2), 43),
            Arguments.of(List.of(100, 1, 2, 1, 1000), 5112),
            Arguments.of(List.of(3, 3, 2, 3), 28)
        );
    }

    private static Stream<Arguments> minCases() {
        return Stream.of(
            Arguments.of(List.of(1), 1),
            Arguments.of(List.of(1000), 1000)
        );
    }

    private static Stream<Arguments> maxCases() {
        return Stream.of(
            Arguments.of(
                IntStream.rangeClosed(1, 1000).boxed().toList(),
                333833500
            ),
            Arguments.of(
                IntStream.rangeClosed(1, 1000).map(v -> 1001 - v).boxed().toList(),
                333833500
            ),
            Arguments.of(
                IntStream.iterate(1000, v -> v).limit(1000).boxed().toList(),
                500500000
            )
        );
    }

    @ParameterizedTest
    @MethodSource({"normalCases", "minCases", "maxCases"})
    void createAnswer(final List<Integer> rices, final int answer) {
        Back1823 back1823 = new Back1823(rices);
        int result = back1823.createAnswer();
        assertThat(result).isEqualTo(answer);
    }
}
