package backjoon.back19637;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Back19637 {

    private final List<Integer> players;
    private final Map<Integer, String> scoreToStatus;
    private final List<Integer> scores;

    public Back19637(final List<Integer> players,
        final Map<Integer, String> scoreToStatus, final List<Integer> scores) {
        this.players = players;
        this.scoreToStatus = scoreToStatus;
        this.scores = scores;
    }

    public List<String> createStatuses() {
        List<String> statues = new LinkedList<>();
        for (final Integer player : players) {
            statues.add(convertStatus(player));
        }
        return statues;
    }

    private String convertStatus(final int player) {
        return binarySearch(player, 0, scores.size());
    }

    private String binarySearch(final int player, final int start, final int end) {
        int mid = (start + end) / 2;
        int score = scores.get(mid);
        if (mid == 0 && player <= score) {
            return scoreToStatus.get(score);
        } else if (player <= score && player > scores.get(mid - 1)) {
            return scoreToStatus.get(score);
        }
        if (player <= score) {
            return binarySearch(player, start, mid - 1);
        }
        return binarySearch(player, mid + 1, end);
    }
}
