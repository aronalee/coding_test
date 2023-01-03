package programmers.여행경로;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Programmers43164Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        String[] result = solution.solution(
            new String[][]{
                {"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
            }
        );
        assertThat(result, equalTo(new String[]{
            "ICN", "JFK", "HND", "IAD"
        }));
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        String[] result = solution.solution(
            new String[][]{
                {"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}
            }
        );
        assertThat(result, equalTo(new String[]{
            "ICN", "ATL", "ICN", "SFO", "ATL", "SFO"
        }));
    }

    @Test
    void case3() {
        Solution solution = new Solution();
        String[] result = solution.solution(
            new String[][]{
                {"ICN", "A"}, {"B", "A"}, {"A", "C"}, {"C", "B"}, {"A", "ICN"}
            }
        );
        assertThat(result, equalTo(new String[]{
            "ICN", "A", "C", "B", "A", "ICN"
        }));
    }

    @Test
    void case4() {
        Solution solution = new Solution();
        String[] result = solution.solution(
            new String[][]{
                {"ICN", "A"}, {"A", "C"}, {"C", "A"}, {"A", "C"}, {"C", "A"}
            }
        );
        assertThat(result, equalTo(new String[]{
            "ICN", "A", "C", "A", "C", "A"
        }));
    }
}