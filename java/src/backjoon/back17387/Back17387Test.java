package backjoon.back17387;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;

class Back17387Test {

    @Test
    void case1() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {1, 5}, {5, 1}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case2() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {6, 10}, {10, 6}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(0));
    }

    @Test
    void case3() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {5, 5}, {1, 1}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case4() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {3, 3}, {5, 5}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case5() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {3, 3}, {1, 3}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case6() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {5, 5}, {9, 9}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case7() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {6, 6}, {9, 9}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(0));
    }

    @Test
    void case8() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {5, 5}, {1, 5}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(1));
    }

    @Test
    void case9() {
        long[][] line1 = new long[][]{
            {1, 1}, {5, 5}
        };
        long[][] line2 = new long[][]{
            {6, 6}, {1, 5}
        };
        Back17387 back17387 = new Back17387(line1, line2);
        int result = back17387.getAnswer();
        assertThat(result, equalTo(0));
    }

}