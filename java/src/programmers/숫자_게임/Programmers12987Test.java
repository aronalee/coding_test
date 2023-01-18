package programmers.숫자_게임;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers12987Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{5, 1, 3, 7},
            new int[]{2, 2, 6, 8}
        );
        assertThat(result).isEqualTo(3);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{2, 2, 2, 2},
            new int[]{1, 1, 1, 1}
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{5, 1, 3, 7},
            new int[]{6, 5, 3, 7}
        );
        assertThat(result).isEqualTo(3);
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{5, 1, 2, 6},
            new int[]{5, 2, 3, 7}
        );
        assertThat(result).isEqualTo(3);
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[]{5, 1, 3, 7},
            new int[]{5, 1, 3, 7}
        );
        assertThat(result).isEqualTo(3);
    }
}