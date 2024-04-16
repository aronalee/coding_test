// prob: https://www.acmicpc.net/problem/2263

package backjoon.back2263;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Back2263Test {

    public static Stream<Arguments> provideBack2263TestCases() {
        return Stream.of(
                Arguments.of(3, List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3)),
                Arguments.of(4, List.of(4, 2, 1, 3), List.of(4, 2, 3, 1), List.of(1, 2, 4, 3))
        );
    }

    @MethodSource("provideBack2263TestCases")
    @ParameterizedTest
    void givenBack2263TestCase_whenComputeSequencePreOrder_thenCorrect(int nodeTotal, List<Integer> sequenceInOrder, List<Integer> sequencePostOrder, List<Integer> sequencePreOrder) {
        // given
        Back2263 back2263 = new Back2263(nodeTotal, sequenceInOrder, sequencePostOrder);

        // when
        List<Integer> actualPreOrder = back2263.computeSequencePreOrder();

        // then
        assertThat(actualPreOrder).usingRecursiveComparison().isEqualTo(sequencePreOrder);
    }

}