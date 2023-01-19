package programmers.보석_쇼핑;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers67258Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{
            "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
        });
        assertThat(result).isEqualTo(new int[]{3, 7});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{
            "AA", "AB", "AC", "AA", "AC"
        });
        assertThat(result).isEqualTo(new int[]{1, 3});
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{
            "XYZ", "XYZ", "XYZ"
        });
        assertThat(result).isEqualTo(new int[]{1, 1});
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int[] result = solution.solution(new String[]{
            "ZZZ", "YYY", "NNNN", "YYY", "BBB"
        });
        assertThat(result).isEqualTo(new int[]{1, 5});
    }

}