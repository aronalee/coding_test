// prob: https://www.acmicpc.net/problem/16928

package backjoon.back16928;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back16928Test {

    public static Stream<Arguments> getTestCases() {
        return Stream.of(Arguments.of(
            List.of(Ladder.of(8, 52),
                Ladder.of(6, 80),
                Ladder.of(26, 42),
                Ladder.of(2, 72)),
            List.of(Snake.of(51, 19),
                Snake.of(39, 11),
                Snake.of(37, 29),
                Snake.of(81, 3),
                Snake.of(59, 5),
                Snake.of(79, 23),
                Snake.of(53, 7),
                Snake.of(43, 33),
                Snake.of(77, 21))
            , 5
        ), Arguments.of(
            List.of(Ladder.of(19, 94),
                Ladder.of(20, 95),
                Ladder.of(21, 96),
                Ladder.of(22, 97),
                Ladder.of(23, 98),
                Ladder.of(24, 99)),
            List.of()
            , 4
        ), Arguments.of(
            List.of(Ladder.of(32, 62),
                Ladder.of(42, 68),
                Ladder.of(12, 98)),
            List.of(Snake.of(95, 13),
                Snake.of(97, 25),
                Snake.of(93, 37),
                Snake.of(79, 27),
                Snake.of(75, 19),
                Snake.of(49, 47),
                Snake.of(67, 17))
            , 3
        ));
    }

    @ParameterizedTest
    @MethodSource("getTestCases")
    void getAnswer(List<Step> ladders, List<Step> snakes, int answer) {
        Back16928 back16928 = new Back16928();
        int result = back16928.getAnswer(ladders, snakes);
        assertThat(result).isEqualTo(answer);
    }
}