package programmers.점찍기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Programmers140107Test {

    @Test
    void case1() {
        Solution s = new Solution();
        assertEquals(s.solution(2, 4), 6);
    }

    @Test
    void case2() {
        Solution s = new Solution();
        assertEquals(s.solution(1, 5), 26);
    }

    @Test
    void case3() {
        Solution s = new Solution();
        assertEquals(s.solution(6, 5), 1);
    }

}