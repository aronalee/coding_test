package programmers.N으로표현;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers42895Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(5, 12);
        assertThat(result, equalTo(4));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(2, 11);
        assertThat(result, equalTo(3));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(5, 25);
        assertThat(result, equalTo(2));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(5, 5);
        assertThat(result, equalTo(1));
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        int result = solution.solution(5, 31168);
        assertThat(result, equalTo(-1));
    }
}