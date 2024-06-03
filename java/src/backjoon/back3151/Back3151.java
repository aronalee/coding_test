// prob: https://www.acmicpc.net/problem/3151

package backjoon.back3151;

import java.util.List;

public class Back3151 {
    private static final int ZERO = 0;

    public long computeSumIsZero(List<Integer> sequence) {
        long zeroSumCount = 0;
        sequence.sort(Integer::compareTo);
        for (int i = 0; i < sequence.size(); i++) {
            int left = i + 1;
            int right = sequence.size() - 1;
            while (left < right) {
                int sum = sequence.get(i) + sequence.get(left) + sequence.get(right);
                if (sum == ZERO) {
                    int leftValue = sequence.get(left);
                    int rightValue = sequence.get(right);
                    if (leftValue == rightValue) {
                        long count = right - left + 1;
                        zeroSumCount += count * (count - 1) / 2;
                        break;
                    }
                    long leftCount = 1;
                    long rightCount = 1;
                    while (left + 1 < right && sequence.get(left + 1) == leftValue) {
                        left++;
                        leftCount++;
                    }
                    while (left < right - 1 && sequence.get(right - 1) == rightValue) {
                        right--;
                        rightCount++;
                    }
                    zeroSumCount += leftCount * rightCount;
                }
                if (sum < ZERO) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return zeroSumCount;
    }

}
