// prob: https://www.acmicpc.net/problem/20182

package backjoon.back20182;

import java.util.*;

public class Back20182 {

    public int findMinShyCost(List<List<Node>> adjList, int src, int dst, int budget) {
        for (int shyCost = 1; shyCost <= 20; shyCost++) {
            if (hasPath(adjList, src, dst, shyCost, budget)) {
                return shyCost;
            }
        }
        throw new NoSuchElementException("Not Found Path");
    }

    private boolean hasPath(List<List<Node>> adjList, int src, int dst, int shyCost, int budget) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        boolean[] visited = new boolean[adjList.size()];
        visited[src] = true;
        queue.add(new Node(src, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.getId() == dst) {
                return true;
            }
            adjList.get(node.getId()).stream()
                    .filter(nextNode -> !visited[nextNode.getId()] &&
                            nextNode.getCost() <= shyCost && node.getCost() + nextNode.getCost() <= budget)
                    .forEach(nextNode -> {
                        visited[nextNode.getId()] = true;
                        queue.add(new Node(nextNode.getId(), node.getCost() + nextNode.getCost()));
                    });
        }
        return false;
    }
}
