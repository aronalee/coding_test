// prob: https://www.acmicpc.net/problem/1495

package backjoon.back1495;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back1495Test {


    public static Stream<Arguments> getTestCases() {
        return Stream.of(
                Arguments.of(List.of(5, 3, 7), 5, 10, 10),
                Arguments.of(List.of(15, 2, 9, 10), 8, 20, Back1495.EMPTY),
                Arguments.of(List.of(74, 39, 127, 95, 63, 140, 99, 96, 154, 18, 137, 162, 14, 88)
                        , 40, 243, 238),
                Arguments.of(List.of(100), 0, 200, 100),
                Arguments.of(List.of(1), 1, 1, 0),
                Arguments.of(List.of(2), 1, 1, Back1495.EMPTY)
        );
    }

    @MethodSource("getTestCases")
    @ParameterizedTest
    void givenVolumesAndStartAndLimitVolume_whenFindMaxVolume_thenMaxVolume(List<Integer> volumes, int startVolume, int limitVolume, int expectedMaxVolume) {
        // given
        Back1495 back1495 = new Back1495(volumes);
        // when
        int actual = back1495.findMaxVolume(startVolume, limitVolume);
        // then
        assertThat(actual).isEqualTo(expectedMaxVolume);
    }

}