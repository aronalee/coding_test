package programmers.택배_배달과_수거하기;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers150369Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        long result = solution.solution(4, 5,
            new int[]{1, 0, 3, 1, 2},
            new int[]{0, 3, 0, 4, 0}
        );
        assertThat(result).isEqualTo(16);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        long result = solution.solution(2, 7,
            new int[]{1, 0, 2, 0, 1, 0, 2},
            new int[]{0, 2, 0, 1, 0, 2, 0}
        );
        assertThat(result).isEqualTo(30);
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        long result = solution.solution(4, 5,
            new int[]{1, 0, 3, 0, 0},
            new int[]{0, 3, 0, 0, 0}
        );
        assertThat(result).isEqualTo(6);
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        long result = solution.solution(1, 5,
            new int[]{2, 0, 3, 0, 0},
            new int[]{0, 3, 0, 0, 0}
        );
        assertThat(result).isEqualTo(22);
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        long result = solution.solution(4, 5,
            new int[]{0, 0, 0, 0, 0},
            new int[]{0, 3, 0, 4, 0}
        );
        assertThat(result).isEqualTo(12);
    }

    @Test
    void case6() {
        Solution solution = new Solution();
        long result = solution.solution(5, 5,
            new int[]{1, 1, 1, 1, 0},
            new int[]{0, 0, 0, 0, 100}
        );
        assertThat(result).isEqualTo(200);
    }
}