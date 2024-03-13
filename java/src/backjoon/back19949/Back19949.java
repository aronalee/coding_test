// prob: https://www.acmicpc.net/problem/19949

package backjoon.back19949;

import java.util.List;

public class Back19949 {
    private final int minScore;

    public Back19949(int minScore) {
        this.minScore = minScore;
    }

    public long countAllCases(List<Integer> answers) {
        return countAllCasesUsingBruteForce(answers);
    }

    private long countAllCasesUsingBruteForce(List<Integer> answers) {
        return countAllCasesUsingBruteForce(answers, 0, 0, -1, 0);
    }

    private long countAllCasesUsingBruteForce(List<Integer> answers, int idx, int currentScore, int answerLatest, int countContinually) {
        if (countContinually > 2) {
            return 0;
        }
        if (answers.size() == idx) {
            return currentScore >= minScore ? 1 : 0;
        }
        int answer = answers.get(idx);
        int nextIdx = idx + 1;
        long count = 0;
        for (int answerSelected = 1; answerSelected <= 5; answerSelected++) {
            int nextScore = currentScore;
            int nextCountContinually = 1;
            if (answerLatest == answerSelected) {
                nextCountContinually = countContinually + 1;
            }
            if (answerSelected == answer) {
                nextScore++;
            }
            count += countAllCasesUsingBruteForce(answers, nextIdx, nextScore, answerSelected, nextCountContinually);
        }
        return count;
    }
}
