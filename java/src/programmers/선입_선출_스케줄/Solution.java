// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12920

package programmers.선입_선출_스케줄;

public class Solution {

    public int solution(int n, int[] cores) {
        if (cores.length >= n) {
            return n;
        }
        int remainedWork = n - cores.length;
        long minTime = 0;
        long maxTime = getMaxTime(n, cores);
        long endTime = getEndTime(remainedWork, cores, minTime, maxTime);
        for (final int core : cores) {
            remainedWork -= (endTime - 1) / core;
        }
        for (int id = 0; id < cores.length; id++) {
            if (endTime % cores[id] == 0) {
                remainedWork--;
            }
            if (remainedWork == 0) {
                return id + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private long getMaxTime(final int n, final int[] cores) {
        int maxTime = 0;
        for (final int workingTime : cores) {
            maxTime = Math.max(maxTime, workingTime);
        }
        maxTime *= n;
        return maxTime;
    }

    private long getEndTime(final int n, final int[] cores, long minTime, long maxTime) {
        while (minTime < maxTime) {
            long mid = (minTime + maxTime) / 2;
            int countWorkings = 0;
            for (final int core : cores) {
                countWorkings += mid / core;
            }
            if (countWorkings >= n) {
                maxTime = mid;
                continue;
            }
            minTime = mid + 1;
        }
        return maxTime;
    }
}
