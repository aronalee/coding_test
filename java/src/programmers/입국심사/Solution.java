// prob: https://school.programmers.co.kr/learn/courses/30/lessons/43238

package programmers.입국심사;

public class Solution {

    private int[] gates;

    public long solution(int n, int[] times) {
        long answer;
        gates = times;
        answer = getMinTime(getMaxTime(n), n);
        return answer;
    }

    private long getMaxTime(long n) {
        int maxGate = 0;
        for (final int gate : gates) {
            maxGate = Math.max(maxGate, gate);
        }
        return n * maxGate;
    }

    private long getMinTime(long maxTime, long n) {
        long minTime = 0;
        while (minTime < maxTime) {
            long mid = (minTime + maxTime) / 2;
            long processedPeople = countProcessedPeople(mid);
            if (processedPeople >= n) {
                maxTime = mid;
                continue;
            }
            minTime = mid + 1;
        }
        return maxTime;
    }

    private long countProcessedPeople(final long currentTime) {
        long count = 0;
        for (final int gate : gates) {
            count += currentTime / gate;
        }
        return count;
    }
}
