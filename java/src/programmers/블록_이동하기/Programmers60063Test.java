package programmers.블록_이동하기;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers60063Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
            }
        );
        assertThat(result).isEqualTo(7);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}
            }
        );
        assertThat(result).isEqualTo(3);
    }
}