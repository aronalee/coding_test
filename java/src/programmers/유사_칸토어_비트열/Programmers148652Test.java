package programmers.유사_칸토어_비트열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Programmers148652Test {

    @ParameterizedTest
    @DisplayName("기본 테스트")
    @CsvSource(value = {
        "2,4,17,8",
        "3,40,125,40"
    })
    void case1(int n, long l, long r, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(n, l, r);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("min 테스트")
    @CsvSource(value = {
        "0,1,1,1",
        "20,1,1,1",
    })
    void case2(int n, long l, long r, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(n, l, r);
        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("max 테스트")
    @CsvSource(value = {
        "20,1,10000001,1081345",
        "20,95367421640625,95367431640625,1081345",
    })
    void case3(int n, long l, long r, int answer) {
        Solution solution = new Solution();
        int result = solution.solution(n, l, r);
        assertThat(result).isEqualTo(answer);
    }
}