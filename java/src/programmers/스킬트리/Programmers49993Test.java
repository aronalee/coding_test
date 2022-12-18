package programmers.스킬트리;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers49993Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution("CBD", new String[]{
            "BACDE", "CBADF", "AECB", "BDA"
        });
        assertThat(result, equalTo(2));
    }
}