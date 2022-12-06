package programmers.빛의경로사이클;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Programmers86052Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"SL", "LR"});
        assertThat(result, equalTo(new int[]{16}));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"S"});
        assertThat(result, equalTo(new int[]{1, 1, 1, 1}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{"R", "R"});
        assertThat(result, equalTo(new int[]{4, 4}));
    }
}