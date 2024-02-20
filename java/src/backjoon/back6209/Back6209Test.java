// prob: https://www.acmicpc.net/problem/6209

package backjoon.back6209;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back6209Test {

    public static Stream<Arguments> Back6209TestCases() {
        return Stream.of(
                Arguments.of(List.of(2, 14, 11, 21, 17), 25, 2, 4),
                Arguments.of(List.of(2, 4, 6), 8, 2, 4),
                Arguments.of(List.of(2), 1_000_000_000, 1, 1_000_000_000),
                Arguments.of(List.of(2), 1_000_000_000, 0, 2)
        );
    }

    @MethodSource("Back6209TestCases")
    @ParameterizedTest
    void givenBack6209TestCases_whenFindMinDistance_thenCorrect(List<Integer> rocks, int exitDistance, int willRemoveCount, int expected) {
        // given
        Back6209 back6209 = new Back6209(exitDistance, new ArrayList<>(rocks), willRemoveCount);

        // when
        int actual = back6209.findMinDistance();

        // then
        assertEquals(expected, actual);
    }

}