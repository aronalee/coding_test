// prob: https://school.programmers.co.kr/learn/courses/30/lessons/133501

package programmers.야간전술보행;

import java.util.ArrayList;
import java.util.List;

class Range {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }
}

class Guard {
    private final Range range;
    private final int workingTime;
    private final int restingTime;

    public Guard(Range range, int workingTime, int restingTime) {
        this.range = range;
        this.workingTime = workingTime;
        this.restingTime = restingTime;
    }

    public Range range() {
        return range;
    }

    public int workingTime() {
        return workingTime;
    }

    public int restingTime() {
        return restingTime;
    }
}


class Solution {
    public int solution(int distance, int[][] scope, int[][] times) {
        List<Guard> guardList = getGuards(scope, times);
        int time = 0;
        while (time < distance) {
            for (Guard guard : guardList) {
                if (time < guard.range().start() - 1 || time > guard.range().end() - 1) {
                    continue;
                }
                int routine = guard.workingTime() + guard.restingTime();
                if (time % routine < guard.workingTime()) {
                    return time + 1;
                }
            }
            time++;
        }
        return time;
    }

    private List<Guard> getGuards(int[][] scope, int[][] times) {
        List<Guard> guardList = new ArrayList<>();
        for (int i = 0; i < scope.length; i++) {
            Range range = new Range(Math.min(scope[i][0], scope[i][1]), Math.max(scope[i][0], scope[i][1]));
            int workingTime = times[i][0];
            int restingTime = times[i][1];
            guardList.add(new Guard(range, workingTime, restingTime));
        }
        return guardList;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(20, new int[][]{{3, 4}, {5, 8}}, new int[][]{{2, 5}, {4, 3}}));
        System.out.println(s.solution(12, new int[][]{{7, 8}, {4, 6}, {11, 10}}, new int[][]{{2, 2}, {2, 4}, {3, 3}}));
    }
}
