// prob: https://www.acmicpc.net/problem/20159

package backjoon.back20159;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back20159Test {

    public static Stream<Arguments> getTestCases() {
        return Stream.of(
                Arguments.of(List.of(3, 2, 5, 2, 1, 3), 11),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1), 3),
                Arguments.of(List.of(9, 1, 9, 1, 9, 1), 27),
                Arguments.of(List.of(1, 9, 1, 9, 1, 9), 27),
                Arguments.of(List.of(1, 1, 1, 1, 1, 1), 3),
                Arguments.of(List.of(1, 2), 2),
                Arguments.of(List.of(2, 1), 2)
        );
    }

    @MethodSource("getTestCases")
    @ParameterizedTest
    public void givenCards_whenFindMaxSum_thenMaxSum(List<Integer> cards, int expect) {
        Back20159 back20159 = new Back20159();
        int actual = back20159.findMaxSum(cards);
        assertThat(actual).isEqualTo(expect);
    }
}