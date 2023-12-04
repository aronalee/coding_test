// prob: https://www.acmicpc.net/problem/1527

package backjoon.back1527;

import java.util.LinkedList;
import java.util.Queue;

public class Back1527 {
    public int countKimNumbers(long min, long max) {
        int count = 0;
        Queue<Long> queue = new LinkedList<>();
        queue.add(4L);
        queue.add(7L);
        while (!queue.isEmpty()) {
            Long number = queue.poll();
            if (number > max) {
                continue;
            }
            if (number >= min) {
                count++;
            }
            queue.add(number * 10 + 4);
            queue.add(number * 10 + 7);
        }
        return count;
    }
}
