// prob: https://school.programmers.co.kr/learn/courses/30/lessons/169199

package programmers.리코쳇_로봇;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers169199Test {


    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(new String[]{
                    "...D..R", ".D.G...", "....D.D", "D....D.", "..D...."
                },
                7),
            Arguments.of(
                new String[]{
                    ".D.R", "....", ".G..", "...D"
                },
                -1
            )
        );
    }

    @MethodSource("backjoonTestCases")
    @ParameterizedTest
    void givenBoard_whenSolution_thenAnswer(String[] board, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(board);
        assertThat(result).isEqualTo(answer);
    }
}