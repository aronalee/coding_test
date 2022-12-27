package programmers.최고의_집합;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers12938Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(2, 9);
        assertThat(result, equalTo(new int[]{4, 5}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(2, 1);
        assertThat(result, equalTo(new int[]{-1}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int[] result = solution.solution(2, 8);
        assertThat(result, equalTo(new int[]{4, 4}));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int[] result = solution.solution(3, 9);
        assertThat(result, equalTo(new int[]{3, 3, 3}));
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        int[] result = solution.solution(4, 9);
        assertThat(result, equalTo(new int[]{2, 2, 2, 3}));
    }
}