// prob: https://www.acmicpc.net/problem/1600

package backjoon.back1600;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1600Test {

    private static Stream<Arguments> backJoonTestCases() {
        return Stream.of(
            Arguments.of(
                1, 4, 4,
                new int[][]{
                    {0, 0, 0, 0},
                    {1, 0, 0, 0},
                    {0, 0, 1, 0},
                    {0, 1, 0, 0},
                }
                , 4
            ),
            Arguments.of(
                2, 5, 2,
                new int[][]{
                    {0, 0, 1, 1, 0},
                    {0, 0, 1, 1, 0},
                }, -1
            )
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(
                30, 5, 2,
                new int[][]{
                    {0, 0, 1, 0, 1},
                    {0, 0, 1, 1, 0},
                }, -1
            ),
            Arguments.of(
                30, 5, 3,
                new int[][]{
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0},
                }, 2
            ),
            Arguments.of(
                1, 5, 3,
                new int[][]{
                    {0, 0, 0, 0, 1},
                    {0, 0, 0, 1, 1},
                    {0, 0, 1, 1, 0},
                }, 4
            )
        );
    }

    @MethodSource({"backJoonTestCases", "customTestCases"})
    @ParameterizedTest
    void getAnswer(int k, int W, int H, int[][] map, int answer) {
        Back1600 back1600 = new Back1600(W, H, map);
        int result = back1600.getAnswer(k);
        assertThat(result).isEqualTo(answer);
    }


}