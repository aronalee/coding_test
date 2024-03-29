// prob: https://www.acmicpc.net/problem/15900

package backjoon.back15900;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back15900 {
    private static final int ROOT = 1;
    private final List<List<Integer>> adjList;


    public Back15900(List<List<Integer>> adjList) {
        this.adjList = adjList;
    }

    public boolean hasWinCase() {
        int leafDepthSum = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[adjList.size() + 1];
        queue.add(new Node(ROOT, 0));
        visited[ROOT] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            List<Integer> adjNodes = adjList.get(node.id);
            if (adjNodes.size() == 1 && node.id != ROOT) {
                leafDepthSum += node.depth;
                visited[node.id] = true;
                continue;
            }
            for (int adjNode : adjNodes) {
                if (visited[adjNode]) {
                    continue;
                }
                visited[adjNode] = true;
                queue.add(new Node(adjNode, node.depth + 1));
            }
        }
        return leafDepthSum % 2 == 1;
    }


    private class Node {
        private final int id;
        private final int depth;

        public Node(int id, int depth) {
            this.id = id;
            this.depth = depth;
        }
    }
}
