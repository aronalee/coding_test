package programmers.표현_가능한_이진트리;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers150367Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new long[]{7, 42, 5}
        );
        assertThat(result).isEqualTo(new int[]{1, 1, 0});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new long[]{63, 111, 95}
        );
        assertThat(result).isEqualTo(new int[]{1, 1, 0});
    }
}