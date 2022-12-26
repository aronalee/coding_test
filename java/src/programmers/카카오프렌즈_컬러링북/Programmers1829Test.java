package programmers.카카오프렌즈_컬러링북;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers1829Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(6, 4,
            new int[][]{
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
            });
        assertThat(result, equalTo(
            new int[]{4, 5}
        ));
    }
}