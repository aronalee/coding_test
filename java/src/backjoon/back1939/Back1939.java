// prob: https://www.acmicpc.net/problem/1939

package backjoon.back1939;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back1939 {
    private final List<List<Node>> adjList;
    private final int totalNodes;
    private int startNodeId;
    private int endNodeId;

    public Back1939(List<List<Node>> adjList, int totalNodes) {
        this.adjList = adjList;
        this.totalNodes = totalNodes;
    }

    public int getMaxCost(List<Integer> points, int minWeight, int maxWeight) {
        startNodeId = points.get(0);
        endNodeId = points.get(1);
        return binarySearch(minWeight, maxWeight);
    }

    private int binarySearch(int startWeight, int endWeight) {
        int midWeight = (startWeight + endWeight) / 2;
        if (endWeight - startWeight <= 1) {
            if (isRouted(endWeight)) {
                return endWeight;
            }
            return startWeight;
        }
        if (isRouted(midWeight)) {
            return binarySearch(midWeight, endWeight);
        }
        return binarySearch(startWeight, midWeight - 1);
    }


    private boolean isRouted(int weight) {
        boolean[] visited = new boolean[totalNodes];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNodeId);
        visited[startNodeId] = true;
        while (!queue.isEmpty()) {
            int currentId = queue.remove();
            if (currentId == endNodeId) {
                return true;
            }
            for (Node node : adjList.get(currentId)) {
                if (visited[node.getId()] || node.getWeight() < weight) {
                    continue;
                }
                queue.add(node.getId());
                visited[node.getId()] = true;
            }
        }
        return false;
    }
}
