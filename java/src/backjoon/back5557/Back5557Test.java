// prob: https://www.acmicpc.net/problem/5557

package backjoon.back5557;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back5557Test {

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(List.of(1, 1, 2), 1),
            Arguments.of(List.of(1, 1, 0), 1),
            Arguments.of(List.of(0, 0, 2), 0)
        );
    }

    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(List.of(8, 3, 2, 4, 8, 7, 2, 4, 0, 8, 8), 10),
            Arguments.of(IntStream.rangeClosed(1, 40).map(v -> {
                if (v == 38 || v == 37) {
                    return 0;
                }
                return 1;
            }).boxed().toList(), 7069052760L)
        );
    }

    @Timeout(1)
    @MethodSource({"backjoonTestCases", "customTestCases"})
    @ParameterizedTest
    void givenNumbers_WhenGetAnswer_ThenAnswer(List<Integer> numbers, long answer) {
        Back5557 back5557 = new Back5557();
        long result = back5557.getAnswer(numbers);
        assertThat(result).isEqualTo(answer);
    }
}