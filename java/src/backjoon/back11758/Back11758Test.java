package backjoon.back11758;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Back11758Test {

    @Test
    void case1() {
        Back11758 back11758 = new Back11758(
            new int[]{1, 1},
            new int[]{5, 5},
            new int[]{7, 3}
        );
        assertThat(back11758.getAnswer(), equalTo(-1));
    }

    @Test
    void case2() {
        Back11758 back11758 = new Back11758(
            new int[]{1, 1},
            new int[]{3, 3},
            new int[]{5, 5}
        );
        assertThat(back11758.getAnswer(), equalTo(0));
    }

    @Test
    void case3() {
        Back11758 back11758 = new Back11758(
            new int[]{1, 1},
            new int[]{7, 3},
            new int[]{5, 5}
        );
        assertThat(back11758.getAnswer(), equalTo(1));
    }


    @Test
    void case4() {
        Back11758 back11758 = new Back11758(
            new int[]{1, -1},
            new int[]{1, -1},
            new int[]{1, -1}
        );
        assertThat(back11758.getAnswer(), equalTo(0));
    }
}