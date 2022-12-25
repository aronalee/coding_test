package programmers.숫자타자대회;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers136797Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution("1756");
        assertThat(result, equalTo(10));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution("5123");
        assertThat(result, equalTo(8));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution("4444466666464464646464464646646464");
        assertThat(result, equalTo(34));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution("1717171717171717171717171717171717");
        assertThat(result, equalTo(39));
    }
}