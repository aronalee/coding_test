// prob: https://www.acmicpc.net/problem/17390

package backjoon.back17390;

import java.util.List;

public class Back17390 {
    private final List<Integer> sequence;
    private int[] subSum;

    public Back17390(List<Integer> sequence) {
        this.sequence = sequence;
    }

    public int computeSum(int start, int end) {
        if (subSum == null) {
            initSubSum();
        }
        return this.subSum[end] - this.subSum[start - 1];
    }

    private void initSubSum() {
        this.subSum = new int[sequence.size() + 1];
        for (int i = 1; i < this.subSum.length; i++) {
            this.subSum[i] = this.sequence.get(i - 1);
            this.subSum[i] += this.subSum[i - 1];
        }
    }
}
