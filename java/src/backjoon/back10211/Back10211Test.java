// prob: https://www.acmicpc.net/problem/10211

package backjoon.back10211;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back10211Test {

    public static Stream<Arguments> provideSequenceAndMaxSum() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5), 15),
                Arguments.of(List.of(2, 1, -2, 3, -5), 4),
                Arguments.of(IntStream.range(0, 1000).boxed().toList(), IntStream.range(0, 1000).sum()),
                Arguments.of(IntStream.range(0, 1000)
                        .map(idx -> idx % 2 == 0 ? idx : -idx).boxed().toList(), 998),
                Arguments.of(IntStream.range(0, 1000)
                                .map(idx -> idx % 2 == 0 ? idx : 0).boxed().toList(),
                        IntStream.range(0, 1000).filter(value -> value % 2 == 0).sum())
        );
    }

    @MethodSource("provideSequenceAndMaxSum")
    @ParameterizedTest
    void givenSequence_whenComputeMaxSum_thenReturnsMaxSum(List<Integer> sequence, int expectedMaxSum) {
        // given
        Back10211 back10211 = new Back10211();

        // when
        int actualMaxSum = back10211.computeMaxSum(sequence);

        // then
        assertEquals(expectedMaxSum, actualMaxSum);
    }

}