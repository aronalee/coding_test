package programmers.억억단을외우자;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

public class Programmers138475Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(8, new int[]{1, 3, 7});
        assertThat(result, equalTo(new int[]{6, 6, 8}));
    }
}