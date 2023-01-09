package programmers.등산코스_정하기;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers118669Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            6,
            new int[][]{
                {1, 2, 3}, {2, 3, 5}, {2, 4, 2},
                {2, 5, 4}, {3, 4, 4}, {4, 5, 3},
                {4, 6, 1}, {5, 6, 1}
            }, new int[]{1, 3}, new int[]{5}
        );
        assertThat(result).isEqualTo(new int[]{5, 3});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            7,
            new int[][]{
                {1, 4, 4}, {1, 6, 1}, {1, 7, 3},
                {2, 5, 2}, {3, 7, 4}, {5, 6, 6}
            }, new int[]{1}, new int[]{2, 3, 4}
        );
        assertThat(result).isEqualTo(new int[]{3, 4});
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            7,
            new int[][]{
                {1, 2, 5}, {1, 4, 1}, {2, 3, 1},
                {2, 6, 7}, {4, 5, 1}, {5, 6, 1},
                {6, 7, 1}
            }, new int[]{3, 7}, new int[]{1, 5}
        );
        assertThat(result).isEqualTo(new int[]{5, 1});
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            5,
            new int[][]{
                {1, 3, 10}, {1, 4, 20}, {2, 3, 4},
                {2, 4, 6}, {3, 5, 20}, {4, 5, 6}
            }, new int[]{1, 2}, new int[]{5}
        );
        assertThat(result).isEqualTo(new int[]{5, 6});
    }
}