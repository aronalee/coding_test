// prob: https://www.acmicpc.net/problem/17451


package backjoon.back17451;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back17451 {

    public long getAnswer(List<Long> speeds) {
        Queue<Long> queue = createQueue(speeds);
        long maxSpeed = queue.remove();
        while (!queue.isEmpty()) {
            long speed = queue.remove();
            if (maxSpeed <= speed) {
                maxSpeed = speed;
                continue;
            }
            if (maxSpeed % speed == 0) {
                continue;
            }
            maxSpeed = (maxSpeed / speed + 1) * speed;
        }
        return maxSpeed;
    }

    private Queue<Long> createQueue(List<Long> speeds) {
        Queue<Long> queue = new LinkedList<>();
        for (int i = speeds.size() - 1; i >= 0; i--) {
            queue.add(speeds.get(i));
        }
        return queue;
    }
}
