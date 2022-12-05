package programmers.가장먼노드;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Programmers49189Test {

    @Test
    void case1() {
        Solution s = new Solution();
        int result = s.solution(6,
            new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2},
                {2, 4}, {5, 2}
            });
        assertEquals(result, 3);
    }
}