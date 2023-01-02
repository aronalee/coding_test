package programmers.아이템줍기;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers87694Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}
            },
            1, 3, 7, 8
        );
        assertThat(result, equalTo(17));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {1, 1, 8, 4}, {2, 2, 4, 9}, {3, 6, 9, 8}, {6, 3, 7, 7}
            },
            9, 7, 6, 1
        );
        assertThat(result, equalTo(11));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {1, 1, 5, 7}
            },
            1, 1, 4, 7
        );
        assertThat(result, equalTo(9));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {2, 1, 7, 5}, {6, 4, 10, 10}
            },
            3, 1, 7, 10
        );
        assertThat(result, equalTo(15));
    }

    @Test
    void case5() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {2, 2, 5, 5}, {1, 3, 6, 4}, {3, 1, 4, 6}
            },
            1, 4, 6, 3
        );
        assertThat(result, equalTo(10));
    }
}