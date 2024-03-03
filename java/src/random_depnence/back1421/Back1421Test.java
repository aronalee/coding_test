// prob: https://www.acmicpc.net/problem/1421

package random_depnence.back1421;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back1421Test {

    public static Stream<Arguments> provideBack1412TestCases() {
        return Stream.of(
                Arguments.of(List.of(26L, 103L, 59L), 1, 10, 1770),
                Arguments.of(List.of(26L, 103L, 59L), 10, 10, 1680),
                Arguments.of(List.of(26L, 103L, 59L), 100, 10, 1230),
                Arguments.of(List.of(26L), 1, 1, 26),
                Arguments.of(List.of(26L, 10000L), 1, 1, 10000)
        );
    }

    @MethodSource("provideBack1412TestCases")
    @ParameterizedTest
    void givenBack1412TestCases_whenComputeMaxPrice_thenExpected(List<Long> woods, long cutCost, long sellingOfOneWood, long expected) {
        // given
        Back1421 back1421 = new Back1421();

        // when
        long actual = back1421.computeMaxPrice(woods, cutCost, sellingOfOneWood);

        // then
        assertEquals(expected, actual);

    }

}