package programmers.테이블_해시_함수;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers147354Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {2, 2, 6},
                {1, 5, 10},
                {4, 2, 9},
                {3, 8, 3},
            }, 2, 2, 3
        );
        assertThat(result).isEqualTo(4);
    }
}