// prob: https://www.acmicpc.net/problem/14916

package backjoon.back14916;

import java.util.Arrays;

public class Back14916 {
    public static final int EMPTY = Integer.MAX_VALUE;
    private static final int[] COINS = {5, 2};

    private static int[] initMemoization(int n) {
        int[] memoization = new int[n + 1];
        Arrays.fill(memoization, EMPTY);
        for (int coin : COINS) {
            if (coin <= n) {
                memoization[coin] = 1;
            }
        }
        return memoization;
    }

    public int countMinCoin(int n) {
        int[] memoization = initMemoization(n);
        return countMinCoin(n, memoization);
    }

    private int countMinCoin(int n, int[] memoization) {
        if (n <= 0) {
            return EMPTY;
        }
        if (memoization[n] != EMPTY) {
            return memoization[n];
        }
        for (int coin : COINS) {
            int countedCoins = countMinCoin(n - coin, memoization);
            if (countedCoins == EMPTY) {
                continue;
            }
            memoization[n] = Math.min(memoization[n], countedCoins + 1);
        }
        return memoization[n];
    }
}
