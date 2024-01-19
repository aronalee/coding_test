// prob: https://www.acmicpc.net/problem/18234

package backjoon.back18234;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back18234Test {

    public static Stream<Arguments> getTestCaseAboutFindMaxSumCarrotTestCases() {
        return Stream.of(
                Arguments.of(List.of(Carrot.of(3, 4)
                        , Carrot.of(1, 2)), 2, 8),
                Arguments.of(List.of(Carrot.of(1, 3)
                        , Carrot.of(2, 9), Carrot.of(3, 7)), 5, 69),
                Arguments.of(List.of(Carrot.of(1, 10)
                        , Carrot.of(2, 9), Carrot.of(3, 8),
                        Carrot.of(3, 5), Carrot.of(6, 6),
                        Carrot.of(5, 6)), 10, 324),
                Arguments.of(List.of(Carrot.of(1, 10), Carrot.of(10, 1),
                        Carrot.of(2, 2)), 3, 35),
                Arguments.of(List.of(Carrot.of(1, 10000)), 11, 100001)
        );

    }

    @MethodSource("getTestCaseAboutFindMaxSumCarrotTestCases")
    @ParameterizedTest
    public void givenCarrotsAndTimeLimit_whenFindMaxSumCarrot_thenMaxSimTaste(List<Carrot> carrots, int limitTime, long expected) {
        Back18234 back18234 = new Back18234();
        long result = back18234.findMaxSumCarrot(limitTime, carrots);
        assertThat(result).isEqualTo(expected);
    }

}