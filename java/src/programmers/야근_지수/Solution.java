// prob: https://school.programmers.co.kr/learn/courses/30/lessons/12927

package programmers.야근_지수;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public long solution(int n, int[] works) {
        Queue<Integer> queue = createPriorityQueue(works);
        balanceWorkAboutN(n, queue);
        return getOverWorkValue(queue);
    }

    private Queue<Integer> createPriorityQueue(int[] works) {
        Queue<Integer> queue = new PriorityQueue<>(
            Comparator.reverseOrder()
        );
        for (int work : works) {
            queue.add(work);
        }
        return queue;
    }

    private void balanceWorkAboutN(int n, Queue<Integer> queue) {
        while (n > 0 && !queue.isEmpty()) {
            n--;
            int work = queue.remove();
            if (work - 1 == 0) {
                continue;
            }
            queue.add(work - 1);
        }
    }

    private long getOverWorkValue(Queue<Integer> queue) {
        long answer = 0;
        while (!queue.isEmpty()) {
            long value = queue.remove();
            answer += value * value;
        }
        return answer;
    }

}
