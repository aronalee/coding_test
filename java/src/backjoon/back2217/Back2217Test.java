package backjoon.back2217;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import org.junit.jupiter.api.Test;

class Back2217Test {

    @Test
    void case1() {
        Back2217 back2217 = new Back2217(
            List.of(10L, 15L)
        );
        assertThat(back2217.getAnswer(), equalTo(20L));
    }

    @Test
    void case2() {
        Back2217 back2217 = new Back2217(
            List.of(10L, 20L, 30L, 40L, 50L, 60L, 100_000L)
        );
        assertThat(back2217.getAnswer(), equalTo(100_000L));
    }

    @Test
    void case3() {
        Back2217 back2217 = new Back2217(
            List.of(10L, 20L, 30L, 40L, 50L, 60L)
        );
        assertThat(back2217.getAnswer(), equalTo(120L));
    }
}