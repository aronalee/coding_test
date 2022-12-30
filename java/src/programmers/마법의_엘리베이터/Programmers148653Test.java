package programmers.마법의_엘리베이터;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers148653Test {

    @Test
    void downZeroStorey_Storey16_Result6() {
        Solution solution = new Solution();
        int result = solution.solution(16);
        assertThat(result, equalTo(6));
    }

    @Test
    void downZeroStorey_Storey2554_Result16() {
        Solution solution = new Solution();
        int result = solution.solution(2554);
        assertThat(result, equalTo(16));
    }

    @Test
    void downZeroStorey_Storey100000_Result1() {
        Solution solution = new Solution();
        int result = solution.solution(100000);
        assertThat(result, equalTo(1));
    }

    @Test
    void downZeroStorey_Storey9999999_Result2() {
        Solution solution = new Solution();
        int result = solution.solution(9999999);
        assertThat(result, equalTo(2));
    }

    @Test
    void downZeroStorey_Storey1990_Result3() {
        Solution solution = new Solution();
        int result = solution.solution(1990);
        assertThat(result, equalTo(3));
    }

    @Test
    void downZeroStorey_Storey9985_Result7() {
        Solution solution = new Solution();
        int result = solution.solution(9985);
        assertThat(result, equalTo(7));
    }

    @Test
    void downZeroStorey_Storey6_Result5() {
        Solution solution = new Solution();
        int result = solution.solution(6);
        assertThat(result, equalTo(5));
    }

    @Test
    void downZeroStorey_Storey75_Result8() {
        Solution solution = new Solution();
        int result = solution.solution(75);
        assertThat(result, equalTo(8));
    }
}