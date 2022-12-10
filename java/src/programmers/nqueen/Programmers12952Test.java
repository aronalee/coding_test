package programmers.nqueen;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Programmers12952Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(4);
        assertThat(result, equalTo(2));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(2);
        assertThat(result, equalTo(0));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(1);
        assertThat(result, equalTo(1));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(8);
        assertThat(result, equalTo(92));
    }
}