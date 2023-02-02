// prob: https://www.acmicpc.net/problem/1103

package backjoon.back1103;

import static backjoon.back1103.STATUS.CYCLE;
import static backjoon.back1103.STATUS.HOLE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1103Test {

    private static Stream<Arguments> normalTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {3, 9, 4, 2, 1, 7, 8},
                {1, 2, 3, 4, 5, 6, 7},
                {9, 1, 2, 3, 5, 3, 2}
            }, 5),
            Arguments.of(new int[][]{
                {2, HOLE.value(), 3, HOLE.value(), HOLE.value(), 4, HOLE.value(), HOLE.value(),
                    HOLE.value(), 5}
            }, 4),
            Arguments.of(new int[][]{
                {3, 9, 9, 4},
                {9, 9, 9, 9},
                {9, 9, 9, 9},
                {2, 9, 2, 4},
            }, CYCLE.value()),
            Arguments.of(new int[][]{
                {2, HOLE.value(), 9, HOLE.value(), HOLE.value(), 1, 1},
                {HOLE.value(), HOLE.value(), 9, HOLE.value(), HOLE.value(), 1, 1},
                {9, HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), 1, 1},
            }, 2),
            Arguments.of(new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            }, CYCLE.value()),
            Arguments.of(new int[][]{
                {3, HOLE.value(), HOLE.value(), 2},
                {HOLE.value(), 1, HOLE.value(), HOLE.value()},
                {HOLE.value(), 2, HOLE.value(), 1},
                {2, 2, 1, 9},
            }, 8)
        );
    }

    public static Stream<Arguments> minTestCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {1}
            }, 1),
            Arguments.of(new int[][]{
                {1, HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
            }, 1),
            Arguments.of(new int[][]{
                {1, HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {1, HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
                {HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(), HOLE.value(),
                    HOLE.value(), HOLE.value()},
            }, CYCLE.value())
        );
    }

    @ParameterizedTest
    @MethodSource({"normalTestCases", "minTestCases"})
    void getAnswer(final int[][] map, final int answer) {
        int maxHeight = map.length;
        int maxWidth = map[0].length;
        Back1103 back1103 = new Back1103(map, new boolean[maxHeight][maxWidth]);
        int result = back1103.createAnswer();
        assertThat(result).isEqualTo(answer);
    }
}