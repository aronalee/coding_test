// prob: https://school.programmers.co.kr/learn/courses/30/lessons/92342

package programmers.양궁대회;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private int maxScore = 0;
    private List<Integer> log = new ArrayList<>();

    public int[] solution(int n, int[] info) {
        List<Integer> apeache = new ArrayList<>();
        for (final int value : info) {
            apeache.add(value);
        }
        createLions(n, apeache, new ArrayList<>());
        if (log.size() == 0) {
            return new int[]{-1};
        }
        int[] answer = new int[log.size()];
        for (int i = 0; i < log.size(); i++) {
            answer[i] = log.get(i);
        }
        return answer;
    }

    private void createLions(int n, List<Integer> apeache, List<Integer> lion) {
        if (lion.size() == apeache.size()) {
            if (n < 0) {
                return;
            }
            if (n > 0) {
                lion.set(lion.size() - 1, lion.get(lion.size() - 1) + n);
            }
            compareLionAndApeache(apeache, new ArrayList<>(lion));
            return;
        }
        int arrowApeache = apeache.get(lion.size());
        lion.add(0);
        createLions(n, apeache, lion);
        lion.remove(lion.size() - 1);
        if (n - arrowApeache >= 0) {
            lion.add(arrowApeache + 1);
            createLions(n - (arrowApeache + 1), apeache, lion);
            lion.remove(lion.size() - 1);
        }
    }

    private void compareLionAndApeache(List<Integer> apeache, List<Integer> lion) {
        int[] scores = createScores(apeache, lion);
        int scoreApeache = scores[0];
        int scoreLion = scores[1];
        if (scoreApeache >= scoreLion) {
            return;
        }
        updateMaxScore(lion, scoreLion - scoreApeache);
    }

    private int[] createScores(final List<Integer> apeache, final List<Integer> lion) {
        int scoreApeache = 0;
        int scoreLion = 0;
        for (int i = 0; i < lion.size(); i++) {
            int score = lion.size() - i - 1;
            if (lion.get(i) < apeache.get(i)) {
                scoreApeache += score;
            } else if (lion.get(i) > apeache.get(i)) {
                scoreLion += score;
            }
        }
        return new int[]{scoreApeache, scoreLion};
    }

    private void updateMaxScore(final List<Integer> logArrow, final int score) {
        if (maxScore > score) {
            return;
        }
        if (maxScore < score) {
            maxScore = score;
            log = logArrow;
            return;
        }
        for (int i = logArrow.size() - 1; i >= 0; i--) {
            if (log.get(i) > logArrow.get(i)) {
                return;
            }
            if (log.get(i) < logArrow.get(i)) {
                log = logArrow;
                return;
            }
        }
    }
    
}
