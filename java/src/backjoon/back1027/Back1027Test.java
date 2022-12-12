package backjoon.back1027;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import org.junit.jupiter.api.Test;

class Back1027Test {

    @Test
    void case1() {
        Back1027 back1027 = new Back1027(15,
            List.of(1, 5, 3, 2, 6, 3, 2, 6, 4, 2, 5, 7, 3, 1, 5));
        assertThat(back1027.getAnswer(), equalTo(7));
    }

    @Test
    void case2() {
        Back1027 back1027 = new Back1027(1,
            List.of(10));
        assertThat(back1027.getAnswer(), equalTo(0));
    }

    @Test
    void case3() {
        Back1027 back1027 = new Back1027(4,
            List.of(5, 5, 5, 5));
        assertThat(back1027.getAnswer(), equalTo(2));
    }

    @Test
    void case4() {
        Back1027 back1027 = new Back1027(5,
            List.of(1, 2, 7, 3, 2));
        assertThat(back1027.getAnswer(), equalTo(4));
    }

    @Test
    void case5() {
        Back1027 back1027 = new Back1027(10,
            List.of(1000000000, 999999999, 999999998, 999999997, 999999996, 1, 2, 3, 4, 5));
        assertThat(back1027.getAnswer(), equalTo(6));
    }

    @Test
    void case6() {
        Back1027 back1027 = new Back1027(10,
            List.of(10, 1, 1, 1, 1, 1, 1, 1, 1, 10));
        assertThat(back1027.getAnswer(), equalTo(9));
    }

    @Test
    void case7() {
        Back1027 back1027 = new Back1027(12,
            List.of(1, 3, 2, 5, 4, 6, 4, 7, 2, 1, 10, 3));
        assertThat(back1027.getAnswer(), equalTo(6));
    }
}