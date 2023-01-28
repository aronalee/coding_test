package programmers.무인도_여행;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers154540Test {

    private static Stream<Arguments> getNormalTestCases() {
        return Stream.of(
            Arguments.of(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"}, new int[]{1, 1, 27}),
            Arguments.of(new String[]{"XXX", "XXX", "XXX"}, new int[]{-1}),
            Arguments.of(new String[]{"XXX1X", "22XXX", "XXXXX"}, new int[]{1, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalTestCases")
    void normalTest(final String[] maps, final int[] answer) {
        Solution solution = new Solution();
        int[] result = solution.solution(maps);
        assertThat(result).isEqualTo(answer);
    }
}