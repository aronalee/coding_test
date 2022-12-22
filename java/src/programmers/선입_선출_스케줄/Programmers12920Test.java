package programmers.선입_선출_스케줄;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers12920Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(6, new int[]{1, 2, 3});
        assertThat(result, equalTo(2));
    }


    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(1, new int[]{1, 2, 3});
        assertThat(result, equalTo(1));
    }
}