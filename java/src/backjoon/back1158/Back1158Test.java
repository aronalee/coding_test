package backjoon.back1158;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back1158Test {

    private static Stream<Arguments> getNormalCase() {
        return Stream.of(
            Arguments.of(7, 3, List.of(3, 6, 2, 7, 5, 1, 4)),
            Arguments.of(7, 1, List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("getNormalCase")
    void case1(int n, int k, List<Integer> answer) {
        Back1158 back1158 = new Back1158();
        List<Integer> result = back1158.getAnswer(n, k);
        assertThat(result).isEqualTo(answer);
    }

}