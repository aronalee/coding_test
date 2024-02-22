// prob: https://www.acmicpc.net/problem/1949

package backjoon.back1949;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back1949Test {


    public static Stream<Arguments> createBack1949TestCases() {
        Stream<Back1949TestCase> back1949TestCaseStream = Stream.of(
                new Back1949TestCase(
                        List.of(1000, 3000, 4000, 1000, 2000, 2000, 7000),
                        List.of(1, 2, 4, 4, 6, 6),
                        List.of(2, 3, 3, 5, 2, 7), 14000,
                        "선택된 노드: 1,3,5,7"
                ),
                new Back1949TestCase(
                        List.of(1000, 100_000, 4000, 1000, 3000, 2000, 7000),
                        List.of(1, 2, 4, 4, 6, 6),
                        List.of(2, 3, 3, 5, 2, 7), 110_000,
                        "선택된 노드: 2,5,7"
                ),
                new Back1949TestCase(
                        List.of(1000), List.of(), List.of(), 1000,
                        "선택된 노드: 1"
                )
        );

        return back1949TestCaseStream.map(testCase -> {
            List<List<Integer>> tree = new ArrayList<>();
            for (int i = 0; i <= testCase.town.size(); i++) {
                tree.add(new ArrayList<>());
            }
            for (int i = 0; i < testCase.parents.size(); i++) {
                tree.get(testCase.parents.get(i) - 1).add(testCase.children.get(i) - 1);
                tree.get(testCase.children.get(i) - 1).add(testCase.parents.get(i) - 1);
            }
            return Arguments.of(
                    testCase.town, tree, testCase.expected, testCase.description
            );
        });
    }

    @MethodSource("createBack1949TestCases")
    @ParameterizedTest(name = "{3}")
    void givenBack1949TestCases_whenSumGoodTownPeople_thenCorrect(List<Integer> towns, List<List<Integer>> tree, int expected, String description) {
        // given
        Back1949 back1949 = new Back1949(towns, tree);

        // when
        int actual = back1949.sumGoodTownPeople();

        // then
        assertEquals(expected, actual);
    }

    private record Back1949TestCase(List<Integer> town, List<Integer> parents, List<Integer> children, int expected,
                                    String description) {
    }
}
