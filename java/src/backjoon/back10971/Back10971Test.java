// prob: https://www.acmicpc.net/problem/10971

package backjoon.back10971;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back10971Test {


    public static Stream<Arguments> getTestCasesAboutFindMinCostTSP() {
        return Stream.of(
                Arguments.of(new int[][]{
                        {0, 10, 15, 20},
                        {5, 0, 9, 10},
                        {6, 13, 0, 12},
                        {8, 8, 9, 0}
                }, 4, 35),
                Arguments.of(new int[][]{
                        {0, 1},
                        {1, 0}
                }, 2, 2),
                Arguments.of(new int[][]{
                        {0, 100, 1},
                        {1, 0, 1},
                        {100, 1, 0}
                }, 3, 3),
                Arguments.of(new int[][]{
                        {0, 0, 100},
                        {100, 0, 1},
                        {0, 100, 0}
                }, 3, 300)
        );
    }

    @MethodSource("getTestCasesAboutFindMinCostTSP")
    @ParameterizedTest
    public void givenAdjMetic_whenFindMinCostTSP_thenCorrect(int[][] adjMetric, int totalNodes, int expected) {
        Back10971 back10971 = new Back10971();
        int result = back10971.findMinCostTSP(totalNodes, adjMetric);
        assertEquals(expected, result);
    }

}