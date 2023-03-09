// prob: https://school.programmers.co.kr/learn/courses/30/lessons/161988

package programmers.연속_펄스_부분_수열의_합;

public class Solution {

    public long solution(int[] sequence) {
        long maxValue = Long.MIN_VALUE;
        maxValue = Math.max(maxValue, getMaxValue(sequence, new long[]{1, -1}));
        maxValue = Math.max(maxValue, getMaxValue(sequence, new long[]{-1, 1}));
        return maxValue;
    }

    private long getMaxValue(int[] sequence, long[] pattern) {
        long[] memoization = new long[sequence.length];
        memoization[0] = sequence[0] * pattern[0];
        for (int i = 1; i < sequence.length; i++) {
            long number = sequence[i] * pattern[i % pattern.length];
            memoization[i] = Math.max(memoization[i - 1] + number, number);
        }
        long maxValue = Long.MIN_VALUE;
        for (long value : memoization) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

}
