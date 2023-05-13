// prob: https://www.acmicpc.net/problem/1092

package backjoon.back1092;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1092Test {

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<>(List.of(6, 8, 9)),
                new ArrayList<>(List.of(100, 1, 1)),
                -1)
        );
    }

    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(new ArrayList<>(List.of(6, 8, 9)),
                new ArrayList<>(List.of(2, 5, 2, 4, 7)),
                2),
            Arguments.of(new ArrayList<>(List.of(19, 20)),
                new ArrayList<>(List.of(14, 12, 16, 19, 16, 1, 5)),
                4),
            Arguments.of(new ArrayList<>(List.of(23, 32, 25, 28)),
                new ArrayList<>(List.of(5, 27, 10, 16, 24, 20, 2, 32, 18, 7)),
                3),
            Arguments.of(new ArrayList<>(List.of(11, 17, 5, 2, 20, 7, 5, 5, 20, 7)),
                new ArrayList<>(List.of(18, 18, 15, 15, 17)),
                2)
        );
    }

    @MethodSource({"backjoonTestCases", "customTestCases"})
    @ParameterizedTest
    void givenCranesAndBoxes_whenGetAnswer_ThenExpected(
        List<Integer> cranes,
        List<Integer> boxes,
        int expected
    ) {
        Back1092 back1092 = new Back1092();
        int actual = back1092.getAnswer(cranes, boxes);
        assertThat(actual).isEqualTo(expected);
    }

}