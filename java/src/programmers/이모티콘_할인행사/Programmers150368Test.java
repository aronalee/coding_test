package programmers.이모티콘_할인행사;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers150368Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{
                {40, 10000}, {25, 10000}
            },
            new int[]{7000, 9000}
        );
        assertThat(result)
            .isEqualTo(new int[]{1, 5_400});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new int[][]{
                {40, 2_900}, {23, 10_000}, {11, 5_200},
                {5, 5_900}, {40, 3_100}, {27, 9_200},
                {32, 6_900}
            },
            new int[]{1300, 1500, 1600, 4900}
        );
        assertThat(result)
            .isEqualTo(new int[]{4, 13_860});
    }
}