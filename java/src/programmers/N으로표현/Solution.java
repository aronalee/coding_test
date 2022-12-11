// prob: https://school.programmers.co.kr/learn/courses/30/lessons/42895

package programmers.N으로표현;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        List<Set<Integer>> memoization = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {
            memoization.add(new HashSet<>());
        }
        memoization.get(1).add(N);
        for (int k = 2; k <= 8; k++) {
            memoization.get(k).add(getValueOnlyN(N, k));
            for (int i = 1; i < k; i++) {
                for (int j = 1; j < k; j++) {
                    if (i + j > k) {
                        continue;
                    }
                    addSubNumbers(memoization, k, i, j);
                }
            }
        }
        for (int i = 1; i < memoization.size(); i++) {
            Set<Integer> set = memoization.get(i);
            if (set.contains(number)) {
                return i;
            }
        }
        return -1;
    }

    private void addSubNumbers(final List<Set<Integer>> memoization, final int k, final int i,
        final int j) {
        for (final Integer value1 : memoization.get(i)) {
            for (final Integer value2 : memoization.get(j)) {
                memoization.get(k).add(value1 + value2);
                if (value1 - value2 > 0) {
                    memoization.get(k).add(value1 - value2);
                }
                memoization.get(k).add(value1 * value2);
                if (value1 / value2 > 0) {
                    memoization.get(k).add(value1 / value2);
                }
            }
        }
    }

    private int getValueOnlyN(final int N, final int count) {
        int value = N;
        for (int i = 1; i < count; i++) {
            value += N * Math.pow(10, i);
        }
        return value;
    }
}
