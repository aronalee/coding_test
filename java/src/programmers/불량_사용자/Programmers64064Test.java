package programmers.불량_사용자;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers64064Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"fr*d*", "abc1**"}
        );
        assertThat(result)
            .isEqualTo(2);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"*rodo", "*rodo", "******"}
        );
        assertThat(result)
            .isEqualTo(2);
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"},
            new String[]{"fr*d*", "*rodo", "******", "******"}
        );
        assertThat(result)
            .isEqualTo(3);
    }
}