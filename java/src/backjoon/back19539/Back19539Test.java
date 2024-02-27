// prob: https://www.acmicpc.net/problem/19539

package backjoon.back19539;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back19539Test {

    public static Stream<Arguments> createTreeHeights() {
        return Stream.of(
                Arguments.of(List.of(0), true),
                Arguments.of(List.of(4, 3), false),
                Arguments.of(List.of(3, 4), false),
                Arguments.of(List.of(10000, 1000, 100), true),
                Arguments.of(List.of(1, 3, 1, 3, 1), false),
                Arguments.of(List.of(5, 2, 2, 2, 2, 2), true),
                Arguments.of(IntStream.rangeClosed(1, 100000).boxed().toList(), false),
                Arguments.of(IntStream.rangeClosed(1, 100000).map(idx -> 9999).boxed().toList(), true)
        );
    }

    @MethodSource("createTreeHeights")
    @ParameterizedTest
    void givenTreeHeights_whenIsAbleToMakeTree_thenExpected(List<Integer> wantTreeHeight, boolean expected) {
        // given
        Back19539 back19539 = new Back19539();

        // when
        boolean actual = back19539.isAbleToMakeTree(wantTreeHeight);

        // then
        assertEquals(expected, actual);
    }

}