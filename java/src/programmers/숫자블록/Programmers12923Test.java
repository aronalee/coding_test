package programmers.숫자블록;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class Programmers12923Test {

    @Test
    void case1() {
        Solution s = new Solution();
        int begin = 1;
        int end = 10;
        int[] result = s.solution(begin, end);
        assertArrayEquals(result, new int[]{0, 1, 1, 2, 1, 3, 1, 4, 3, 5});
    }

    @Test
    void case2() {
        Solution s = new Solution();
        int begin = 10_000_000;
        int end = 10_000_003;
        int[] result = s.solution(begin, end);
        assertArrayEquals(result, new int[]{5_000_000, 909_091, 5_000_001, 769_231});
    }

    @Test
    void case3() {
        Solution s = new Solution();
        int begin = 17171771;
        int end = 17171771;
        int[] result = s.solution(begin, end);
        assertArrayEquals(result, new int[]{1});
    }

}