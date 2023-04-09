// prob: https://www.acmicpc.net/problem/1713

package backjoon.back1713;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1713Test {

    public static Stream<Arguments> backjoonTestCases() {
        return Stream.of(
            Arguments.of(3,
                List.of("2", "1", "4", "3", "5", "6", "2", "7", "2").toArray(new String[0]),
                List.of(2, 6, 7))
        );
    }

    @MethodSource("backjoonTestCases")
    @ParameterizedTest
    void getAnswer(int n, String[] votes, List<Integer> answer) {
        Back1713 back1713 = new Back1713();
        List<Integer> result = back1713.getAnswer(n, votes);
        assertThat(result)
            .usingRecursiveComparison()
            .isEqualTo(answer);
    }
}