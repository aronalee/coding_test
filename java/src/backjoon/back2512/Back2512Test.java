package backjoon.back2512;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Back2512Test {

    @Test
    void case1() {
        Back2512 back2512 = new Back2512(List.of(120, 110, 140, 150), 485);
        int result = back2512.findMaxAllocatedBudge();
        assertThat(result).isEqualTo(127);
    }

    @Test
    void case2() {
        Back2512 back2512 = new Back2512(List.of(70, 80, 30, 40, 100), 450);
        int result = back2512.findMaxAllocatedBudge();
        assertThat(result).isEqualTo(100);
    }

    @Test
    void case3() {
        Back2512 back2512 = new Back2512(List.of(1, 1, 1, 99999), 450);
        int result = back2512.findMaxAllocatedBudge();
        assertThat(result).isEqualTo(447);
    }
}