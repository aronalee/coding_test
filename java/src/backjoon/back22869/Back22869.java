// prob: https://www.acmicpc.net/problem/22869

package backjoon.back22869;

import java.util.LinkedList;
import java.util.Queue;

public class Back22869 {

    public boolean hasRootLeftToRight(int[] rocks, int powerMax) {
        boolean[] visited = new boolean[rocks.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (now == rocks.length - 1) {
                return true;
            }
            if (visited[now]) {
                continue;
            }
            for (int next = now + 1; next < rocks.length; next++) {
                if (getPower(now, next, rocks) >= powerMax) {
                    continue;
                }
                visited[now] = true;
                queue.add(next);
            }
        }
        return false;
    }

    private int getPower(int now, int next, int[] rocks) {
        return (next - now) * (1 + Math.abs(rocks[next] - rocks[now]));
    }
}
