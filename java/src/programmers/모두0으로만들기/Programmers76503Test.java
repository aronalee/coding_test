package programmers.모두0으로만들기;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers76503Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{-5, 0, 2, 1, 2},
            new int[][]{
                {0, 1}, {3, 4}, {2, 3}, {0, 3}
            });
        assertThat(result, equalTo(9L));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{0, 1, 0},
            new int[][]{
                {0, 1}, {1, 2}
            });
        assertThat(result, equalTo(-1L));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{5, 0, -2, -1, -2},
            new int[][]{
                {0, 1}, {3, 4}, {2, 3}, {0, 3}
            });
        assertThat(result, equalTo(9L));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{0, 1},
            new int[][]{
                {0, 1}
            });
        assertThat(result, equalTo(-1L));
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{0, 0},
            new int[][]{
                {0, 1}
            });
        assertThat(result, equalTo(0L));
    }

    @Test
    void case6() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{-5, 1, 2, 2},
            new int[][]{
                {1, 3}, {1, 2}, {0, 1}
            });
        assertThat(result, equalTo(9L));
    }

}