// prob: https://school.programmers.co.kr/learn/courses/30/lessons/154538

package programmers.숫자_변환하기;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[] memoization;

    public int solution(int x, int y, int n) {
        memoization = new int[y + 1];
        Arrays.fill(memoization, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        memoization[x] = 0;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (now == y) {
                return memoization[y];
            }
            addNextIfMinCount(now * 2, now, queue);
            addNextIfMinCount(now * 3, now, queue);
            addNextIfMinCount(now + n, now, queue);
        }
        return -1;
    }


    private void addNextIfMinCount(
        int next,
        int now,
        Queue<Integer> queue
    ) {
        int nextCount = memoization[now] + 1;
        if (next < memoization.length && memoization[next] > nextCount) {
            memoization[next] = nextCount;
            queue.add(next);
        }
    }
}
