package backjoon.back19637;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class Back19637Test {

    @Test
    void case1() {
        Map<Integer, String> map = Map.of(
            10_000, "WEAK",
            100_000, "NORMAL",
            1_000_000, "STRONG"
        );
        List<Integer> players = List.of(
            0, 9_999, 10_000, 10_001, 50_000,
            100_000, 500_000, 1_000_000
        );
        List<Integer> scores = List.of(
            10_000, 100_000, 1_000_000
        );
        Back19637 back19637 = new Back19637(players, map, scores);
        List<String> statuses = back19637.createStatuses();
        assertThat(statuses,
            equalTo(List.of(
                "WEAK", "WEAK", "WEAK", "NORMAL",
                "NORMAL", "NORMAL", "STRONG", "STRONG")
            ));
    }

    @Test
    void case2() {
        Map<Integer, String> map = Map.of(
            100, "B",
            1_000, "C"
        );
        List<Integer> players = List.of(99, 100, 101, 500, 1_000);
        List<Integer> scores = List.of(100, 1_000);
        Back19637 back19637 = new Back19637(players, map, scores);
        List<String> statuses = back19637.createStatuses();
        assertThat(statuses, equalTo(List.of("B", "B", "C", "C", "C")));
    }
}