package backjoon.back2206;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Back2206Test {

    @Test
    void case1() {
        Back2206 back2206 = new Back2206(6, 4,
            new boolean[][]{
                {false, true, false, false},
                {true, true, true, false},
                {true, false, false, false},
                {false, false, false, false},
                {false, true, true, true},
                {false, false, false, false}
            });
        assertThat(back2206.getAnswer()).isEqualTo(15);
    }

    @Test
    void case2() {
        Back2206 back2206 = new Back2206(4, 4,
            new boolean[][]{
                {false, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, false}
            });
        assertThat(back2206.getAnswer()).isEqualTo(-1);
    }
}