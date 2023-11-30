// prob: https://www.acmicpc.net/problem/1699

package backjoon.back1699;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Back1699 {

    private static final int INIT_VALUE = 1000000;
    private final List<Integer> squares = new ArrayList<>();
    private int[] memoization;

    public int getMinSquare(int n) {
        initMemoization(n);
        return findMinSquare(n);
    }

    private void initMemoization(int n) {
        memoization = new int[n + 1];
        Arrays.fill(memoization, INIT_VALUE);
        memoization[0] = 0;
        for (int i = 0; Math.pow(i, 2) <= n; i++) {
            int square = (int) Math.pow(i, 2);
            memoization[square] = 1;
            squares.add(square);
        }
    }

    private int findMinSquare(int n) {
        if (n < 0) {
            return INIT_VALUE;
        }
        if (memoization[n] != INIT_VALUE) {
            return memoization[n];
        }
        for (int i = squares.size() - 1; i >= 0; i--) {
            int square = squares.get(i);
            int result = findMinSquare(n - square) + 1;
            if (result < memoization[n]) {
                memoization[n] = result;
            }
        }
        return memoization[n];
    }
}
