package programmers.디펜스게임;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers142085Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1});
        assertThat(result, equalTo(5));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(2, 4, new int[]{3, 3, 3, 3});
        assertThat(result, equalTo(4));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(6, 1, new int[]{4, 2, 4, 5, 3, 3, 1});
        assertThat(result, equalTo(3));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(2, 4, new int[]{3, 3, 3, 3, 3});
        assertThat(result, equalTo(4));
    }
}