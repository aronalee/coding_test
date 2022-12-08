package programmers.순위;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Programmers49191Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(5, new int[][]{
            {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        });
        assertThat(result, equalTo(2));
    }
}