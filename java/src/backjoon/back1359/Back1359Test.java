// prob: https://www.acmicpc.net/problem/1359

package backjoon.back1359;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back1359Test {


    public static Stream<Arguments> getLottoInfo() {
        return Stream.of(
                Arguments.of(3, 1, 1, 0.3333333333333333),
                Arguments.of(3, 2, 1, 1.0),
                Arguments.of(8, 2, 1, 0.4642857142857143),
                Arguments.of(8, 4, 2, 0.7571428571428571),
                Arguments.of(2, 1, 1, 0.5),
                Arguments.of(4, 3, 1, 1)
        );
    }

    private static double removeMistake(double result) {
        double digit = Math.pow(10, 15);
        return Math.floor(result * digit) / digit;
    }

    @MethodSource("getLottoInfo")
    @ParameterizedTest
    void givenLottoInfo_whenComputeWinPercent_thenCorrect(int n, int m, int k, double expected) {
        Back1359 back1359 = new Back1359();
        double actual = back1359.computeWinPercent(n, m, k);
        assertEquals(removeMistake(expected), removeMistake(actual));
    }

}