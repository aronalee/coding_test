package programmers.교점에별만들기;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Programmers87377Test {

    @Test
    void case1() {
        Solution s = new Solution();
        String[] result = s.solution(new int[][]{
            {2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}
        });
        assertArrayEquals(result,
            new String[]{
                "....*....",
                ".........",
                ".........",
                "*.......*",
                ".........",
                ".........",
                ".........",
                ".........",
                "*.......*"
            });
    }

    @Test
    void case2() {
        Solution s = new Solution();
        String[] result = s.solution(new int[][]{
            {0, 1, -1}, {1, 0, -1}, {1, 0, 1}
        });
        assertArrayEquals(result,
            new String[]{
                "*.*"
            });
    }

    @Test
    void case3() {
        Solution s = new Solution();
        String[] result = s.solution(new int[][]{
            {1, -1, 0}, {2, -1, 0}
        });
        assertArrayEquals(result,
            new String[]{
                "*"
            });
    }

    @Test
    void case4() {
        Solution s = new Solution();
        String[] result = s.solution(new int[][]{
            {1, -1, 0}, {2, -1, 0}, {4, -1, 0}
        });
        assertArrayEquals(result,
            new String[]{
                "*"
            });
    }
}