// prob: https://www.acmicpc.net/problem/16928

package backjoon.back16928;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Back16928 {

    public int getAnswer(List<Step> ladders, List<Step> snakes) {
        Map<Integer, Step> pointToStep = new HashMap<>();
        for (Step ladder : ladders) {
            pointToStep.put(ladder.getSrc(), ladder);
        }
        for (Step snake : snakes) {
            pointToStep.put(snake.getSrc(), snake);
        }
        boolean[] visited = new boolean[106];
        int start = 1;
        visited[start] = true;
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.countDices));
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.point >= 100) {
                return now.countDices;
            }
            for (int i = 1; i <= 6; i++) {
                int next = now.point + i;
                if (visited[next]) {
                    continue;
                }
                if (pointToStep.containsKey(next)) {
                    Step step = pointToStep.get(next);
                    visited[step.getDst()] = true;
                    queue.add(new Node(step.getDst(), now.countDices + 1));
                    continue;
                }
                visited[next] = true;
                queue.add(new Node(next, now.countDices + 1));
            }
        }
        throw new IllegalArgumentException();
    }

    private static class Node {

        private final int point;
        private final int countDices;

        public Node(int point, int countDices) {
            this.point = point;
            this.countDices = countDices;
        }
    }

}
