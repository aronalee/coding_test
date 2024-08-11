// prob: https://github.com/tony9402/baekjoon/blob/main/picked.md

package random_depence.back1620;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Back18115Test {

    public static Stream<Arguments> provideParams() {
        return Stream.of(
            Arguments.of(List.of(1, 1, 1, 1, 1), List.of(5, 4, 3, 2, 1)),
            Arguments.of(List.of(2, 3, 3, 2, 1), List.of(1, 5, 2, 3, 4)),
            Arguments.of(List.of(3, 3, 3, 3, 3), List.of(1, 2, 3, 4, 5)),
            Arguments.of(List.of(1), List.of(1))
        );
    }

    @MethodSource("provideParams")
    @ParameterizedTest
    void givenActions_whenComputeInitBatch_thenInitBatch(List<Integer> actions,
        List<Integer> initBatch) {
        // when
        Back18115 back18115 = new Back18115();
        List<Integer> result = back18115.computeInitBatch(actions);

        // then
        assertThat(result)
            .usingRecursiveAssertion()
            .isEqualTo(initBatch);
    }

}