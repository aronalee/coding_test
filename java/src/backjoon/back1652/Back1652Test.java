package backjoon.back1652;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1652Test {

    private static Stream<Arguments> getTestCases() {
        return Stream.of(
            Arguments.of(
                new boolean[][]{
                    {false, false, false, false, true},
                    {false, false, true, true, false},
                    {false, false, false, false, false},
                    {false, true, true, false, false},
                    {true, false, false, false, false},
                }, new int[]{5, 4}
            ),
            Arguments.of(
                new boolean[][]{
                    {false, true, true, true, true},
                    {false, true, true, true, true},
                    {false, true, true, true, true},
                    {false, true, true, true, true},
                    {true, true, true, true, true},
                }, new int[]{0, 1}
            ),
            Arguments.of(
                new boolean[][]{
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                    {true, true, true, true, true},
                }, new int[]{0, 0}
            ),
            Arguments.of(
                new boolean[][]{
                    {true},
                }, new int[]{0, 0}
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    void normalTest(final boolean[][] map, final int[] correctAnswer) {
        Back1652 back1652 = new Back1652();
        int[] answer = back1652.getAnswer(map);
        assertThat(answer).isEqualTo(correctAnswer);
    }
}