package backjoon.back2146;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Back2146Test {

    @Test
    void case1() {
        Back2146 back2146 = new Back2146(
            new int[][]{
                {1, 1, 1, 0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            }
        );
        int answer = back2146.getAnswer();
        assertThat(answer).isEqualTo(3);
    }
}