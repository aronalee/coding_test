// prob: https://www.acmicpc.net/problem/5557


package backjoon.back5557;

import java.util.List;

public class Back5557 {

    public long getAnswer(List<Integer> numbers) {
        long[] memoization = new long[21];
        memoization[numbers.get(0)] = 1;
        for (int i = 1; i < numbers.size() - 1; i++) {
            int number = numbers.get(i);
            memoization = createNextMemoization(memoization, number);
        }
        int dstValue = numbers.get(numbers.size() - 1);
        return memoization[dstValue];
    }

    private long[] createNextMemoization(long[] memoization, int number) {
        long[] nextMemoization = new long[21];
        for (int preNumber = 0; preNumber < memoization.length; preNumber++) {
            if (memoization[preNumber] == 0) {
                continue;
            }
            for (Integer nextValue : List.of(preNumber + number, preNumber - number)) {
                if (IsInvalidateValue(nextValue)) {
                    continue;
                }
                nextMemoization[nextValue] += memoization[preNumber];
            }
        }
        return nextMemoization;
    }

    private boolean IsInvalidateValue(int value) {
        return value < 0 || value > 20;
    }
}
