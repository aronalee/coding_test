// prob: https://school.programmers.co.kr/learn/courses/30/lessons/138476

package programmers.귤고르기;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Counter {

    private final int size;
    private int count;

    public Counter(final int size, final int count) {
        this.size = size;
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public int getCount() {
        return count;
    }

    public void countOne() {
        count++;
    }
}

class Solution {

    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        List<Counter> counters = new LinkedList<>();
        Counter current = createCounters(tangerine, counters);
        sortingCounterByCountReversed(counters, current);
        return fillInTangerineOverK(k, counters);
    }

    private Counter createCounters(final int[] tangerine, final List<Counter> counters) {
        Counter current = new Counter(0, 0);
        for (final int tangerineSize : tangerine) {
            if (current.getSize() == tangerineSize) {
                current.countOne();
                continue;
            }
            counters.add(current);
            current = new Counter(tangerineSize, 1);
        }
        return current;
    }

    private void sortingCounterByCountReversed(final List<Counter> counters,
        final Counter current) {
        counters.add(current);
        counters.sort(Comparator.comparing(Counter::getCount).reversed());
    }

    private int fillInTangerineOverK(final int k, final List<Counter> counters) {
        int countTangerineSize = 0;
        int countTangerine = 0;
        for (final Counter counter : counters) {
            countTangerine += counter.getCount();
            countTangerineSize++;
            if (countTangerine >= k) {
                break;
            }
        }
        return countTangerineSize;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(s.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }

}
