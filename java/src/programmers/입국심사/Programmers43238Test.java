package programmers.입국심사;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers43238Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        long result = solution.solution(6, new int[]{7, 10});
        assertThat(result, equalTo(28L));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        long result = solution.solution(1, new int[]{7, 10});
        assertThat(result, equalTo(7L));
    }

}