package programmers.부대복귀;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers132266Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(3,
            new int[][]{{1, 2}, {2, 3}},
            new int[]{2, 3}, 1);
        assertThat(result, equalTo(new int[]{1, 2}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(5,
            new int[][]{{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}},
            new int[]{1, 3, 5}, 5);
        assertThat(result, equalTo(new int[]{2, -1, 0}));
    }


}