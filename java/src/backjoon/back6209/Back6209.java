// prob: https://www.acmicpc.net/problem/6209

package backjoon.back6209;

import java.util.List;

public class Back6209 {
    private final int exitDistance;
    private final List<Integer> rocks;
    private final int willRemoveCount;

    public Back6209(int exitDistance, List<Integer> rocks, int willRemoveCount) {
        this.exitDistance = exitDistance;
        this.rocks = rocks;
        this.willRemoveCount = willRemoveCount;
    }


    public int findMinDistance() {
        rocks.add(0);
        rocks.add(exitDistance);
        rocks.sort(Integer::compareTo);
        return findMinDistance(0, exitDistance);
    }

    private int findMinDistance(int start, int end) {
        int minDistance = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int now = 0;
            int countIsBiggerDistance = 0;
            for (int i = 1; i < rocks.size(); i++) {
                int distance = rocks.get(i) - rocks.get(now);
                if (distance < mid) {
                    countIsBiggerDistance++;
                    continue;
                }
                now = i;
            }
            if (countIsBiggerDistance > willRemoveCount) {
                end = mid - 1;
                continue;
            }
            start = mid + 1;
            minDistance = Math.max(mid, minDistance);
        }
        return minDistance;
    }


}
