// prob: https://www.acmicpc.net/problem/20159

package backjoon.back20159;

import java.util.List;

public class Back20159 {

    public int findMaxSum(List<Integer> cards) {
        int[] accSum = new int[cards.size()];
        initAccSum(cards, accSum);
        int lastDealerIdx = cards.size() - 2;
        int lastPlayerIdx = cards.size() - 1;
        int maxSum = Math.max(accSum[lastDealerIdx], accSum[lastPlayerIdx]);
        for (int turn = 1; turn < cards.size() - 1; turn++) {
            int currentScore = accSum[turn - 1];
            int willReturnScore = accSum[lastPlayerIdx] - accSum[turn] + cards.get(turn) - cards.get(lastPlayerIdx);
            if (turn % 2 == 0) {
                currentScore = accSum[turn - 2];
                willReturnScore = accSum[lastPlayerIdx] - accSum[turn - 1];
            }
            maxSum = Math.max(maxSum, currentScore + willReturnScore);
        }
        return maxSum;
    }

    private void initAccSum(List<Integer> cards, int[] accSum) {
        accSum[0] = cards.get(0);
        accSum[1] = cards.get(1);
        for (int i = 2; i < cards.size(); i += 2) {
            accSum[i] = accSum[i - 2] + cards.get(i);
        }
        for (int i = 3; i < cards.size(); i += 2) {
            accSum[i] = accSum[i - 2] + cards.get(i);
        }
    }

}
