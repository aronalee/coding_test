package backjoon.back1083;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1083Test {

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of(
                List.of(10, 20, 30, 40, 50, 60, 70),
                1,
                List.of(20, 10, 30, 40, 50, 60, 70)
            ),
            Arguments.of(
                List.of(3, 5, 1, 2, 4),
                2,
                List.of(5, 3, 2, 1, 4)
            ),
            Arguments.of(
                List.of(19, 20, 17, 18, 15, 16, 13, 14, 11, 12),
                5,
                List.of(20, 19, 18, 17, 16, 15, 14, 13, 12, 11)
            ),
            Arguments.of(
                IntStream.range(1, 51).boxed().collect(Collectors.toList()),
                1_000_000,
                IntStream.range(0, 50).map(i -> 50 - i).boxed().collect(Collectors.toList())
            ),
            Arguments.of(
                List.of(1),
                1_000_000,
                List.of(1)
            )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void getAnswerTest(final List<Integer> list, final int s, List<Integer> answer) {
        Back1083 back1083 = new Back1083();
        List<Integer> result = back1083.createAnswer(list, s);
        assertThat(result).isEqualTo(answer);
    }
}