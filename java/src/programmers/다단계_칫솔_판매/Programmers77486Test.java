package programmers.다단계_칫솔_판매;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Programmers77486Test {

    @Test
    void case1() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
            new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
            new String[]{"young", "john", "tod", "emily", "mary"},
            new int[]{12, 4, 2, 5, 10}
        );
        assertThat(result).isEqualTo(new int[]{360, 958, 108, 0, 450, 18, 180, 1080});
    }

    @Test
    void case2() {
        Solution solution = new Solution();
        int[] result = solution.solution(
            new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
            new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
            new String[]{"sam", "emily", "jaimie", "edward"},
            new int[]{2, 3, 5, 4}
        );
        assertThat(result).isEqualTo(new int[]{0, 110, 378, 180, 270, 450, 0, 0});
    }
}