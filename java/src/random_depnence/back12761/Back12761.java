// prob: https://www.acmicpc.net/problem/12761

package random_depnence.back12761;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Back12761 {
    private final int step1;
    private final int step2;

    public Back12761(int step1, int step2) {
        this.step1 = step1;
        this.step2 = step2;
    }

    public int computeStepMin(int src, int dst) {
        boolean[] visited = new boolean[100001];
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.stepCount));
        queue.add(new Node(src, 0));
        visited[src] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.position == dst) {
                return node.stepCount;
            }
            int[] nextPositions = new int[]{node.position - 1, node.position + 1,
                    node.position - step1, node.position + step1,
                    node.position - step2, node.position + step2,
                    node.position * step1, node.position * step2};
            for (int nextPosition : nextPositions) {
                if (nextPosition < 0 || nextPosition > 100000 || visited[nextPosition]) {
                    continue;
                }
                visited[nextPosition] = true;
                queue.add(new Node(nextPosition, node.stepCount + 1));
            }
        }
        throw new IllegalStateException("no path src to dst");
    }


    private class Node {
        private final int position;
        private final int stepCount;

        public Node(int position, int stepCount) {
            this.position = position;
            this.stepCount = stepCount;
        }
    }
}
