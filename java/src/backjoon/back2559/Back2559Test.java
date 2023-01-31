// prob: https://www.acmicpc.net/problem/2559

package backjoon.back2559;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back2559Test {

    private static Stream<Arguments> getNormalCases() {
        return Stream.of(
            Arguments.of(
                List.of(3, -2, -4, -9, 0, 3, 7, 13, 8, -3), 2, 21
            ),
            Arguments.of(
                List.of(3, -2, -4, -9, 0, 3, 7, 13, 8, -3), 5, 31
            ),
            Arguments.of(
                List.of(-1, -1, -1, -1, -1, -1, -1, -1, 1000), 5, 996
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalCases")
    void getAnswer(List<Integer> numbers, int k, int answer) {
        Back2559 back2559 = new Back2559();
        int result = back2559.getAnswer(numbers, k);
        assertThat(result).isEqualTo(answer);
    }

}