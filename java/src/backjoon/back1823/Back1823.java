// prob: https://www.acmicpc.net/problem/1823


package backjoon.back1823;

import java.util.List;

public class Back1823 {

    private final List<Integer> rices;
    private int[][] memoization;

    public Back1823(List<Integer> rices) {
        this.rices = rices;
    }

    public int createAnswer() {
        memoization = new int[rices.size()][rices.size()];
        return findMaxWeight(0, rices.size() - 1, 1);
    }

    private int findMaxWeight(int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        if (memoization[left][right] != 0) {
            return memoization[left][right];
        }
        int leftRice = rices.get(left);
        int rightRice = rices.get(right);
        return memoization[left][right]
            = Math.max(
            findMaxWeight(left + 1, right, k + 1) + getRiceWeight(k, leftRice),
            findMaxWeight(left, right - 1, k + 1) + getRiceWeight(k, rightRice)
        );
    }

    private int getRiceWeight(int k, int rice) {
        return rice * k;
    }
}
