// https://www.acmicpc.net/problem/16195

package random_depense.back16195;

import java.util.Arrays;

public class Back16195 {

    private static final long INIT_VALUE = Long.MAX_VALUE;
    private static final long DIVIDER = 1_000_000_009;
    // dp[number][limit]: number를 정확히 limit 개수의 숫자로 채움
    private final long[][] dp = new long[1001][1001];

    public Back16195() {
        for (long[] longs : dp) {
            Arrays.fill(longs, INIT_VALUE);
        }
        Arrays.fill(dp[0], 0);
        for (int i = 0; i < dp[0].length; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= 3; i++) {
            dp[i][1] = 1;
        }
    }

    public long countAllCases(int number, int limit) {
        long acc = 0;
        // limit 이하의 모든 경우의 수를 더한 결과가 답
        for (int i = limit; i > 0; i--) {
            acc += countCases(number, i);
            acc %= DIVIDER;
        }
        return acc;
    }

    private long countCases(int number, int limit) {
        if (number < 1 || limit < 1) {
            return 0;
        }
        if (dp[number][limit] != INIT_VALUE) {
            return dp[number][limit];
        }
        dp[number][limit] = (countCases(number - 1, limit - 1) +
                countCases(number - 2, limit - 1) +
                countCases(number - 3, limit - 1)) % DIVIDER;
        return dp[number][limit];
    }
}
