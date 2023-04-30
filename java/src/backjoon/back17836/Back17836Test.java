// prob: https://www.acmicpc.net/problem/17836

package backjoon.back17836;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back17836Test {


    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 2},
                {1, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
            }, 16, 10),
            Arguments.of(new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 2, 0},
            }, 100, -1)
        );
    }

    public static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {0, 0, 2},
                {0, 0, 0},
                {0, 0, 0},
            }, 5, 4),
            Arguments.of(new int[][]{
                {0, 0, 1, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
            }, 7, 7),
            Arguments.of(new int[][]{
                {0, 0, 0, 0, 0},
                {0, 1, 2, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
            }, 7, 7),
            Arguments.of(new int[][]{
                {0, 1, 2, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1},
                {1, 1, 1, 0},
            }, 9, -1)
        );
    }

    @MethodSource({"backjoonTestCases", "customTestCases"})
    @ParameterizedTest
    void givenCastles_WhenGetAnswer_ThenMinTime(int[][] castles, int timeLimit, int answer) {
        Back17836 back17836 = new Back17836();
        assertThat(back17836.getAnswer(castles, timeLimit))
            .isEqualTo(answer);
    }
}