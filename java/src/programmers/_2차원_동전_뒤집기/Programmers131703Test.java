package programmers._2차원_동전_뒤집기;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers131703Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 1, 0}
            },
            new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1}
            }
        );
        assertThat(result, equalTo(5));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            },
            new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {0, 0, 0}
            }
        );
        assertThat(result, equalTo(-1));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
            },
            new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
            }
        );
        assertThat(result, equalTo(2));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(
            new int[][]{
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 0}
            },
            new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}
            }
        );
        assertThat(result, equalTo(4));
    }
}