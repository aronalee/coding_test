package backjoon.back2621;

import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

class Back2621Test {

    @Test
    void testCase0() {
        Back2621 back2621 = new Back2621(
            List.of(3, 7, 1, 2, 7),
            List.of('B', 'B', 'R', 'B', 'Y')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(207)
        );
    }

    @Test
    void testCase1() {
        Back2621 back2621 = new Back2621(
            List.of(4, 3, 2, 5, 6),
            List.of('Y', 'Y', 'Y', 'Y', 'Y')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(906)
        );
    }

    @Test
    void testCase2() {
        Back2621 back2621 = new Back2621(
            List.of(3, 3, 7, 3, 3),
            List.of('B', 'R', 'B', 'Y', 'G')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(803)
        );
    }

    @Test
    void testCase3() {
        Back2621 back2621 = new Back2621(
            List.of(5, 5, 7, 5, 7),
            List.of('R', 'Y', 'G', 'B', 'Y')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(757)
        );
    }

    @Test
    void testCase4() {
        Back2621 back2621 = new Back2621(
            List.of(3, 4, 8, 6, 7),
            List.of('Y', 'Y', 'Y', 'Y', 'Y')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(608)
        );
    }

    @Test
    void testCase5() {
        Back2621 back2621 = new Back2621(
            List.of(7, 8, 9, 6, 5),
            List.of('R', 'R', 'G', 'Y', 'B')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(509)
        );
    }

    @Test
    void testCase6() {
        Back2621 back2621 = new Back2621(
            List.of(7, 7, 2, 7, 5),
            List.of('R', 'Y', 'R', 'G', 'R')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(407)
        );
    }

    @Test
    void testCase7() {
        Back2621 back2621 = new Back2621(
            List.of(5, 5, 4, 9, 4),
            List.of('R', 'Y', 'Y', 'G', 'B')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(354)
        );
    }

    @Test
    void testCase8() {
        Back2621 back2621 = new Back2621(
            List.of(5, 2, 5, 3, 4),
            List.of('R', 'Y', 'B', 'B', 'G')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(205)
        );
    }


    @Test
    void testCase9() {
        Back2621 back2621 = new Back2621(
            List.of(1, 2, 4, 8, 5),
            List.of('R', 'R', 'B', 'B', 'Y')
        );
        int result = back2621.getAnswer();
        MatcherAssert.assertThat(
            result, equalTo(108)
        );
    }
}