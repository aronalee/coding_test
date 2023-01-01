package programmers.정수_삼각형;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers43105Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
            }
        );
        assertThat(result, equalTo(30));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {7},
            }
        );
        assertThat(result, equalTo(7));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {7},
                {1, 2}
            }
        );
        assertThat(result, equalTo(9));
    }
}