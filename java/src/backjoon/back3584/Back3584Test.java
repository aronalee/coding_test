// prob: https://www.acmicpc.net/problem/3584

package backjoon.back3584;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Back3584Test {

    static Stream<Arguments> getBack3584TestCases() {
        Stream<TestCase> testCaseStream = Stream.of(
                new TestCase(
                        List.of(1, 8, 10, 5, 4, 8, 4, 1, 6, 10, 6, 10, 16, 8, 16),
                        List.of(14, 5, 16, 9, 6, 4, 10, 13, 15, 11, 7, 2, 3, 1, 12),
                        16, 7, 4),
                new TestCase(List.of(2, 3, 3, 1), List.of(3, 4, 1, 5), 3, 5, 3),
                new TestCase(List.of(1), List.of(2), 1, 2, 1),
                new TestCase(List.of(1, 1), List.of(2, 3), 2, 3, 1)
        );
        return testCaseStream.map(testCase -> {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i <= testCase.parents.size() + 1; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < testCase.parents.size(); i++) {
                int parent = testCase.parents.get(i);
                int child = testCase.children.get(i);
                adjList.get(child).add(parent);
            }
            return Arguments.of(adjList, testCase.node1, testCase.node2, testCase.expected);
        });

    }

    @MethodSource("getBack3584TestCases")
    @ParameterizedTest
    void givenOneTestCase_whenFindNearestCommonAnscestor_thenFound(List<List<Integer>> adjList, int node1, int node2, int expected) {
        // given
        Back3584 back3584 = new Back3584();

        // when
        int actual = back3584.findNearestCommonAnscestor(adjList, node1, node2);

        // then
        assertEquals(expected, actual);
    }

    private record TestCase(List<Integer> parents, List<Integer> children, int node1, int node2, int expected) {
    }

}