// prob: https://www.acmicpc.net/problem/5446

package backjoon.back5446;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back5446Test {

    public static Stream<Arguments> getTestCases() {
        return Stream.of(
                Arguments.of(
                        List.of("BAPC.in", "BAPC.out", "BAPC.tex",
                                "filter", "filename", "filenames", "clean",
                                "cleanup.IN1", "cleanup.IN2", "cleanup.out", "problem.tex"),
                        List.of("BAPC", "files", "cleanup", "cleanup.IN", "cleaning"), 8),
                Arguments.of(List.of("nana"), List.of("n"), 1),
                Arguments.of(List.of("nana"), List.of("nanana"), 1),
                Arguments.of(List.of("a", "b", "c", "d"), List.of(), 1)
        );
    }

    @MethodSource("getTestCases")
    @ParameterizedTest
    public void givenTestCases_whenFindMinDeleteCount_thenReturnResult(List<String> willRemoveFiles, List<String> notRemoveFiles, int expected) {
        // given
        Back5446 back5446 = new Back5446();

        // when
        int actual = back5446.findMinDeleteCount(willRemoveFiles, notRemoveFiles);

        // then
        assertEquals(expected, actual);
    }

}