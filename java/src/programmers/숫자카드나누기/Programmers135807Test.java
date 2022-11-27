package programmers.숫자카드나누기;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Programmers135807Test {

    @Test
    public void case1() {
        Solution s = new Solution();
        assertEquals(s.solution(new int[]{10, 17}, new int[]{5, 20}), 0);
    }

    @Test
    public void case2() {
        Solution s = new Solution();
        assertEquals(s.solution(new int[]{10, 20}, new int[]{5, 17}), 10);
    }

    @Test
    public void case3() {
        Solution s = new Solution();
        assertEquals(s.solution(new int[]{14, 35, 119}, new int[]{18, 30, 102}), 7);
    }

}