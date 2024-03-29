// prob: https://www.acmicpc.net/problem/15900

package backjoon.back15900;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Back15900Test {

    public static Stream<Arguments> provideWinCases() {
        return Stream.of(
                new int[][]{{1, 2}},
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}},
                new int[][]{{1, 2}, {1, 3}, {1, 4}}
        ).map(Back15900Test::covertArrayToAdjList);
    }

    public static Stream<Arguments> provideLoseCases() {
        return Stream.of(
                new int[][]{{1, 2}, {2, 3}, {2, 4}},
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                new int[][]{{8, 1}, {1, 4}, {7, 4}, {6, 4}, {6, 5}, {1, 3}, {2, 3}}
        ).map(Back15900Test::covertArrayToAdjList);
    }

    private static Arguments covertArrayToAdjList(int[][] array) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= array.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] nodes : array) {
            adjList.get(nodes[0]).add(nodes[1]);
            adjList.get(nodes[1]).add(nodes[0]);
        }
        return Arguments.of(adjList);
    }

    @MethodSource("provideWinCases")
    @ParameterizedTest
    void givenWinCases_whenHasWinCase_thenTrue(List<List<Integer>> adjList) {
        // given
        Back15900 back15900 = new Back15900(adjList);

        // when & then
        assertTrue(back15900.hasWinCase());

    }

    @MethodSource("provideLoseCases")
    @ParameterizedTest
    void givenLoseCases_whenHasWinCase_thenFalse(List<List<Integer>> adjList) {
        // given
        Back15900 back15900 = new Back15900(adjList);

        // when & then
        assertFalse(back15900.hasWinCase());
    }
}