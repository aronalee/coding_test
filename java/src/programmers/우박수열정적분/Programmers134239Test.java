package programmers.우박수열정적분;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class Programmers134239Test {

    @Test
    void case1() {
        Solution s = new Solution();
        assertArrayEquals(s.solution(5,
                new int[][]{
                    {0, 0}, {0, -1}, {2, -3}, {3, -3}
                }),
            new double[]{
                33.0, 31.5, 0.0, -1.0
            });
    }

}