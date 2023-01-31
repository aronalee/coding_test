// prob: https://www.acmicpc.net/problem/2559

package backjoon.back2559;

import java.util.ArrayList;
import java.util.List;

public class Back2559 {

    public int getAnswer(List<Integer> numbers, int k) {
        List<Integer> sums = createSumList(numbers, k);
        return findMaxSum(sums);
    }

    private List<Integer> createSumList(List<Integer> numbers, int k) {
        List<Integer> sums = new ArrayList<>();
        int initSum = 0;
        for (int i = 0; i < k; i++) {
            initSum += numbers.get(i);
        }
        sums.add(initSum);
        for (int i = k; i < numbers.size(); i++) {
            int lastSum = sums.get(sums.size() - 1);
            sums.add(lastSum - numbers.get(i - k) + numbers.get(i));
        }
        return sums;
    }

    private int findMaxSum(List<Integer> sums) {
        int maxValue = Integer.MIN_VALUE;
        for (Integer sum : sums) {
            maxValue = Math.max(maxValue, sum);
        }
        return maxValue;
    }

}
