package programmers.등대;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers133500Test {

    @Test
//    2          6
//      \      /
//    3 - 1 - 5 - 7
//      /      \
//    4          8
    void case1() {
        Solution solution = new Solution();
        int result = solution.solution(
            8, new int[][]{
                {1, 2}, {1, 3},
                {1, 4}, {1, 5},
                {5, 6}, {5, 7},
                {5, 8}
            }
        );
        assertThat(result, equalTo(2));
    }

    @Test
//  4       5       7
//    \   /   \   /
//      1       6
//    /   \       \
//  2       3       8
//    \
//      9
//    /
//  10
    void case2() {
        Solution solution = new Solution();
        int result = solution.solution(
            10, new int[][]{
                {4, 1}, {5, 1},
                {5, 6}, {7, 6},
                {1, 2}, {1, 3},
                {6, 8}, {2, 9},
                {9, 10}
            }
        );
        assertThat(result, equalTo(3));
    }


    @Test
//          11
//          |
//  4       5       7
//    \   /   \   /
//      1       6
//    /   \       \
//  2       3       8
//    \
//      9
//    /
//  10
    void case3() {
        Solution solution = new Solution();
        int result = solution.solution(
            11, new int[][]{
                {4, 1}, {5, 1},
                {5, 6}, {7, 6},
                {1, 2}, {1, 3},
                {6, 8}, {2, 9},
                {9, 10}, {5, 11}
            }
        );
        assertThat(result, equalTo(4));
    }

    @Test
//  4       5  - 6
//    \   /
//      1
//    /   \
//  2       3
    void case4() {
        Solution solution = new Solution();
        int result = solution.solution(
            6, new int[][]{
                {1, 2}, {1, 3},
                {1, 4}, {1, 5},
                {5, 6}
            }
        );
        assertThat(result, equalTo(2));
    }

    @Test
//  4       5
//    \   /
//      1 - 6
//    /   \
//  2       3
    void case5() {
        Solution solution = new Solution();
        int result = solution.solution(
            6, new int[][]{
                {1, 2}, {1, 3},
                {1, 4}, {1, 5},
                {1, 6}
            }
        );
        assertThat(result, equalTo(1));
    }


    @Test
//  4       5
//    \   /
//      1 - 6
//    /   \
//  2       3
//  |
//  7
    void case6() {
        Solution solution = new Solution();
        int result = solution.solution(
            7, new int[][]{
                {1, 2}, {1, 3},
                {1, 4}, {1, 5},
                {1, 6}, {2, 7}
            }
        );
        assertThat(result, equalTo(2));
    }

    @Test
//    1    -     2
    void case7() {
        Solution solution = new Solution();
        int result = solution.solution(
            2, new int[][]{
                {1, 2},
            }
        );
        assertThat(result, equalTo(1));
    }
}