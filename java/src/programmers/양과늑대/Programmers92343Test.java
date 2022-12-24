package programmers.양과늑대;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers92343Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1},
            new int[][]{
                {0, 1}, {1, 2}, {1, 4},
                {0, 8}, {8, 7}, {9, 10},
                {9, 11}, {4, 3}, {6, 5},
                {4, 6}, {8, 9}
            }
        );
        assertThat(result, equalTo(5));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
            new int[][]{
                {0, 1}, {0, 2}, {1, 3},
                {1, 4}, {2, 5}, {2, 6},
                {3, 7}, {4, 8}, {6, 9}, {9, 10}
            }
        );
        assertThat(result, equalTo(5));
    }


    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0},
            new int[][]{
                {0, 1}, {0, 2}, {1, 3},
                {1, 4}, {2, 5}, {2, 6},
                {3, 7}, {4, 8}, {6, 9}, {9, 10}
            }
        );
        assertThat(result, equalTo(1));
    }
}