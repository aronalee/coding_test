package programmers.시소_짝꿍;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class Programmers152996Test {

    @Test
    @DisplayName("기본 테스트")
    void case1() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{
            100, 180, 360, 100, 270
        });
        assertThat(result).isEqualTo(4L);
    }

    @Test
    @DisplayName("다섯 사람이 모두 같은 무게여서 시소의 쌍의 개수는 5C2 이다.")
    void case2() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{
            100, 100, 100, 100, 100
        });
        assertThat(result).isEqualTo(10L);
    }


    @Test
    @DisplayName("세 사람이 이 모두 같은 무게이므로 시소 쌍 개수는 3C2 이다.")
    void case3() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{
            100, 100, 100
        });
        assertThat(result).isEqualTo(3L);
    }

    @Test
    @DisplayName("무게가 100인 사람이 3명,무게가 200인 사람이 2명이므로 시소 쌍 개수는 3C2+2C2+3C1*2C1 이다.")
    void case4() {
        Solution solution = new Solution();
        long result = solution.solution(new int[]{
            100, 100, 100, 200, 200
        });
        assertThat(result).isEqualTo(10L);
    }
}