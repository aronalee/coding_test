package programmers.경주로_건설;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers67259Test {


    private static Stream<Arguments> getNormalCases() {
        return Stream.of(
            Arguments.of(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }, 900),
            Arguments.of(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
            }, 3800),
            Arguments.of(new int[][]{
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 1, 0, 1},
                {1, 0, 0, 0}
            }, 2100),
            Arguments.of(new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
            }, 3200),
            Arguments.of(new int[][]{
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0}
            }, 4100)
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalCases")
    void normalTest(final int[][] board, final int answer) {
        Solution solution = new Solution();
        int result = solution.solution(board);
        assertThat(result).isEqualTo(answer);
    }
}