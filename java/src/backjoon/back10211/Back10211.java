// prob: https://www.acmicpc.net/problem/10211

package backjoon.back10211;

import java.util.Arrays;
import java.util.List;

public class Back10211 {
    private final int EMPTY = -1_000_000;

    public int computeMaxSum(List<Integer> testCase) {
        int[][] dp = initDp(testCase);
        return findMaxSum(testCase, dp);
    }

    private int[][] initDp(List<Integer> testCase) {
        int[][] dp = new int[testCase.size()][testCase.size()];
        for (int[] array : dp) {
            Arrays.fill(array, EMPTY);
        }
        for (int idx = 0; idx < testCase.size(); idx++) {
            dp[idx][idx] = testCase.get(idx);
        }
        return dp;
    }

    private int findMaxSum(List<Integer> testCase, int[][] dp) {
        int maxValue = EMPTY;
        for (int i = 0; i < testCase.size(); i++) {
            maxValue = Math.max(maxValue, dp[i][i]);
            for (int j = i + 1; j < testCase.size(); j++) {
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + testCase.get(j);
                    maxValue = Math.max(maxValue, dp[i][j]);
                    continue;
                }
                dp[i][j] = dp[i - 1][j] - dp[i - 1][j - 1] + dp[i][j - 1];
                maxValue = Math.max(maxValue, dp[i][j]);
            }
        }
        return maxValue;
    }
}
