package programmers.단어변환;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers43163Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution("hit", "cog",
            new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assertThat(result, equalTo(4));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution("hit", "cog",
            new String[]{"hot", "dot", "dog", "lot", "log"});
        assertThat(result, equalTo(0));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution("hit", "cog",
            new String[]{"hit", "hot", "dot", "dog", "lot", "log", "cog"});
        assertThat(result, equalTo(4));
    }
}