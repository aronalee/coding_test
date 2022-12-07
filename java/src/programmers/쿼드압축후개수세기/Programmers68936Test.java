package programmers.쿼드압축후개수세기;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Programmers68936Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{
                {1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}
            }
        );
        assertThat(result, equalTo(new int[]{4, 9}));

    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {
                0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {
                0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}}
        );
        assertThat(result, equalTo(new int[]{10, 15}));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{{1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 1}}
        );
        assertThat(result, equalTo(new int[]{0, 1}));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{
                {1}}
        );
        assertThat(result, equalTo(new int[]{0, 1}));
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}}
        );
        assertThat(result, equalTo(new int[]{8, 14}));
    }
}