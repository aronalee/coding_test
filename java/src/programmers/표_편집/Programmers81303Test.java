package programmers.표_편집;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers81303Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        String result = solution.solution(8, 2, new String[]{
            "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
        });
        assertThat(result)
            .isEqualTo("OOOOXOOO");
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        String result = solution.solution(8, 2, new String[]{
            "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
        });
        assertThat(result)
            .isEqualTo("OOXOXOOO");
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        String result = solution.solution(1_000_000, 0, new String[]{
            "D 200000", "D 200000", "D 200000", "D 200000", "D 200000",
            "U 200000", "U 200000", "U 200000", "U 200000", "U 200000",
        });
        assertThat(result)
            .isEqualTo("O".repeat(1_000_000));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        String result = solution.solution(10, 5, new String[]{
            "U 5", "U 5", "U 5", "C", "D 5", "D 5", "D 5", "D 5", "C", "Z", "U 5", "Z"
        });
        assertThat(result)
            .isEqualTo("O".repeat(10));
    }
}