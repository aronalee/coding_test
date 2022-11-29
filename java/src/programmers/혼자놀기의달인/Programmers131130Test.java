package programmers.혼자놀기의달인;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Programmers131130Test {

    @Test
    void case1() {
        Solution s = new Solution();
        assertEquals(s.solution(new int[]{
            8, 6, 3, 7, 2, 5, 1, 4
        }), 12);
    }

}