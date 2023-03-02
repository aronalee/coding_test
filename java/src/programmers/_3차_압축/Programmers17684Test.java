// prob: https://school.programmers.co.kr/learn/courses/30/lessons/17684

package programmers._3차_압축;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers17684Test {

    private static Stream<Arguments> programmersTestCases() {
        return Stream.of(
            Arguments.of(
                "KAKAO",
                new int[]{11, 1, 27, 15}
            ),
            Arguments.of(
                "TOBEORNOTTOBEORTOBEORNOT",
                new int[]{20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34}
            ),
            Arguments.of(
                "ABABABABABABABAB", new int[]{1, 2, 27, 29, 28, 31, 30}
            )
        );
    }

    private static Stream<Arguments> customTestCases() {
        return Stream.of(
            Arguments.of(
                "A",
                new int[]{1}
            ),
            Arguments.of(
                "A".repeat(1000),
                new int[]{1, 27, 28, 29, 30, 31, 32, 33,
                    34, 35, 36, 37, 38, 39, 40, 41, 42,
                    43, 44, 45, 46, 47, 48, 49, 50, 51,
                    52, 53, 54, 55, 56, 57, 58, 59, 60,
                    61, 62, 63, 64, 65, 66, 67, 68, 69, 35}
            )
        );
    }

    @MethodSource({"programmersTestCases", "customTestCases"})
    @ParameterizedTest
    public void solution(String msg, int[] answer) {
        Solution solution = new Solution();
        int[] result = solution.solution(msg);
        assertThat(result).isEqualTo(answer);
    }
}