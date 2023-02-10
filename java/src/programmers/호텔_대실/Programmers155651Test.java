// prob: https://school.programmers.co.kr/learn/courses/30/lessons/155651

package programmers.호텔_대실;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers155651Test {

    public static Stream<Arguments> getNormalCases() {
        return Stream.of(
            Arguments.of(
                new String[][]{
                    {"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"},
                    {"18:20", "21:20"}
                }, 3
            ),
            Arguments.of(
                new String[][]{
                    {"09:10", "10:10"}, {"10:20", "12:20"}
                }, 1
            ),
            Arguments.of(
                new String[][]{
                    {"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}
                }, 3
            )
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalCases")
    void solution(String[][] bookTime, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(bookTime);
        assertThat(result).isEqualTo(answer);
    }

}
