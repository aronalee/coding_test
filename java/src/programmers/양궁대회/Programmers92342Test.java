package programmers.양궁대회;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Programmers92342Test {

    @Test
    void case1() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(s.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0}),
            new int[]{
                0, 2, 2, 0, 1, 0, 0, 0, 0, 0, 0
            });
    }

    @Test
    void case2() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(s.solution(1, new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}),
            new int[]{
                -1
            });
    }

    @Test
    void case3() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(s.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}),
            new int[]{
                1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0
            });
    }

    @Test
    void case4() {
        Solution s = new Solution();
        Assertions.assertArrayEquals(s.solution(10, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3}),
            new int[]{
                1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 2
            });
    }

}