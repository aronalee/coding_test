package programmers.표_병합;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Programmers150366Test {


    private static Stream<Arguments> normalCases() {
        return Stream.of(
            Arguments.of(new String[]{
                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean",
                "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
                "UPDATE 4 3 noodle",
                "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik",
                "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"
            }, new String[]{"EMPTY", "group"}),
            Arguments.of(new String[]{
                "UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d",
                "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1",
                "UNMERGE 2 2", "PRINT 1 1"
            }, new String[]{"d", "EMPTY"}),
            Arguments.of(new String[]{
                "UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap",
                "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean",
                "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian",
                "UPDATE 4 3 noodle",
                "MERGE 1 1 1 2", "MERGE 1 1 2 1", "PRINT 2 1",
                "MERGE 3 3 4 3", "PRINT 4 3",
                "UPDATE noodle category", "PRINT 4 3",
                "UPDATE menu category", "PRINT 2 1",
                "UNMERGE 2 1", "PRINT 1 1", "PRINT 2 1"
            }, new String[]{"menu", "noodle", "category", "category", "EMPTY", "category"}),
            Arguments.of(new String[]{
                "UPDATE 1 1 menu", "UPDATE 1 2 menu", "UPDATE 2 1 menu",
                "UPDATE 2 2 menu", "UPDATE 2 3 menu", "UPDATE 3 1 menu", "UPDATE 3 2 menu",
                "UPDATE 3 3 menu", "UPDATE 3 4 menu", "UPDATE 4 1 menu", "UPDATE 4 2 menu",
                "UPDATE 4 3 menu",
                "MERGE 1 1 1 2", "MERGE 1 1 2 1", "PRINT 2 1",
                "MERGE 3 3 4 3", "PRINT 4 3",
                "UNMERGE 2 1", "PRINT 1 1", "PRINT 2 1",
                "UPDATE menu acc", "PRINT 2 1", "PRINT 1 1", "PRINT 3 3", "PRINT 4 3"
            }, new String[]{
                "menu",
                "menu",
                "EMPTY", "menu",
                "acc", "EMPTY", "acc", "acc"}),
            Arguments.of(new String[]{
                "UPDATE 1 1 menu", "UPDATE 2 1 menu", "UPDATE 2 2 menu",
                "PRINT 1 1", "PRINT 2 1", "PRINT 2 2",
                "MERGE 1 1 1 2", "MERGE 1 1 2 1", "MERGE 1 1 2 2",
                "PRINT 1 1", "PRINT 2 1", "PRINT 2 2",
                "UNMERGE 2 1",
                "PRINT 1 1", "PRINT 2 1", "PRINT 2 2",
            }, new String[]{
                "menu", "menu", "menu",
                "menu", "menu", "menu",
                "EMPTY", "menu", "EMPTY",}),
            Arguments.of(new String[]{
                "UPDATE 1 1 010", "UPDATE 1 2 101", "UPDATE 1 3 _101",
                "PRINT 1 1", "PRINT 1 2", "PRINT 1 3"
            }, new String[]{
                "010", "101", "_101"})
        );
    }

    private static Stream<Arguments> nullCases() {
        return Stream.of(
            Arguments.of(new String[]{
                "MERGE 1 1 1 2", "UNMERGE 1 1", "PRINT 1 1"
            }, new String[]{"EMPTY"}),
            Arguments.of(new String[]{
                "UPDATE 1 1 a", "UNMERGE 1 1", "PRINT 1 1"
            }, new String[]{"a"}),
            Arguments.of(new String[]{
                "PRINT 1 1", "PRINT 50 50"
            }, new String[]{"EMPTY", "EMPTY"}),
            Arguments.of(new String[]{
                "UPDATE A B", "UNMERGE 1 2", "UNMERGE 3 5", "UPDATE B C", "PRINT 1 2", "PRINT 3 5"
            }, new String[]{"EMPTY", "EMPTY"})
        );
    }

    @ParameterizedTest
    @MethodSource("normalCases")
    void testDefaultCase(final String[] commands, final String[] answer) {
        Solution solution = new Solution();
        String[] result = solution.solution(commands);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @MethodSource("nullCases")
    void testNullCases(final String[] commands, final String[] answer) {
        Solution solution = new Solution();
        String[] result = solution.solution(commands);
        assertThat(result).isEqualTo(answer);
    }
}