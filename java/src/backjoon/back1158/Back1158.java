// prob: https://www.acmicpc.net/problem/1158

package backjoon.back1158;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back1158 {

    public List<Integer> getAnswer(final int n, final int k) {
        List<Integer> sequence = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        while (!queue.isEmpty()) {
            for (int step = 0; step < k - 1 && !queue.isEmpty(); step++) {
                queue.add(queue.remove());
            }
            sequence.add(queue.remove());
        }
        return sequence;
    }
}
