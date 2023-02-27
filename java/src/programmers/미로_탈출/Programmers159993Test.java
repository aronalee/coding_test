// prob: https://school.programmers.co.kr/learn/courses/30/lessons/159993

package programmers.미로_탈출;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers159993Test {

    public static Stream<Arguments> programmersTest() {
        return Stream.of(
            Arguments.of(new String[]{
                "SOOOL",
                "XXXXO",
                "OOOOO",
                "OXXXX",
                "OOOOE"
            }, 16),
            Arguments.of(new String[]{
                "LOOXS",
                "OOOOX",
                "OOOOO",
                "OOOOO",
                "EOOOO"
            }, -1)
        );
    }

    private static Stream<Arguments> customTest() {
        return Stream.of(
            Arguments.of(new String[]{
                "SOOOE",
                "XXXXO",
                "OOOOL"
            }, 8),
            Arguments.of(new String[]{
                "SEL",
            }, 3)
        );
    }

    @MethodSource({"programmersTest", "customTest"})
    @ParameterizedTest
    void solution(String[] map, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(map);
        assertThat(result).isEqualTo(answer);
    }
}