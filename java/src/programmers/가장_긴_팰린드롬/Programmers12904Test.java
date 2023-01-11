package programmers.가장_긴_팰린드롬;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class Programmers12904Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution("abcdcba");
        Assertions.assertThat(result).isEqualTo(7);
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution("abacde");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution("ababababababab");
        Assertions.assertThat(result).isEqualTo(13);
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution("ab".repeat(1250));
        Assertions.assertThat(result).isEqualTo(2499);
    }
}