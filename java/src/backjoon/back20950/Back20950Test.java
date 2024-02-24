// prob: https://www.acmicpc.net/problem/20950

package backjoon.back20950;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back20950Test {


    public static Stream<Arguments> createBack20950TestCases() {
        return Stream.of(
                Arguments.of(
                        List.of(Colour.of(255, 0, 0),
                                Colour.of(0, 255, 0),
                                Colour.of(0, 0, 255)),
                        Colour.of(64, 64, 64), Colour.of(85, 85, 85)),
                Arguments.of(
                        List.of(Colour.of(255, 255, 255),
                                Colour.of(255, 130, 151)),
                        Colour.of(255, 255, 255), Colour.of(255, 192, 203)),
                Arguments.of(
                        List.of(Colour.of(255, 255, 255),
                                Colour.of(0, 0, 0)),
                        Colour.of(255, 255, 255), Colour.of(127, 127, 127)),
                Arguments.of(
                        List.of(Colour.of(255, 255, 255),
                                Colour.of(0, 0, 0)),
                        Colour.of(0, 0, 0), Colour.of(127, 127, 127))
        );
    }

    @DisplayName("문도리색 찾기")
    @MethodSource("createBack20950TestCases")
    @ParameterizedTest
    void givenBack20950TestCases_whenFindClosestColour_thenColour(List<Colour> canMixColours, Colour goalColour, Colour expected) {
        // given
        Back20950 back20950 = new Back20950();
        // when
        Colour actual = back20950.findClosestColour(canMixColours, goalColour);
        // then
        assertThat(expected)
                .usingRecursiveComparison()
                .isEqualTo(actual);
    }

    @DisplayName("곰도리색과 문도리색의 차이 계산")
    @Test
    void givenColourAndGoalColour_whenComputeDifference_thenDifference() {
        // given
        Back20950 back20950 = new Back20950();
        Colour colour = Colour.of(255, 255, 255);
        Colour goalColour = Colour.of(0, 0, 0);

        // when
        int actual = back20950.computeDifference(colour, goalColour);

        // then
        assertThat(actual).isEqualTo(765);
    }
}
