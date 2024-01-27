// prob: https://www.acmicpc.net/problem/10971

package backjoon.back10971;

import java.util.HashSet;
import java.util.Set;

public class Back10971 {
    private static final int INIT_VALUE = 1_000_000 * 11;
    private int[][] adjMetric;
    private int totalNode;


    public int findMinCostTSP(int totalNodes, int[][] adjMetric) {
        this.adjMetric = adjMetric;
        this.totalNode = totalNodes;
        int minCost = INIT_VALUE;
        for (int nodeId = 0; nodeId < totalNodes; nodeId++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(nodeId);
            Node start = new Node(nodeId, 0);
            int result = computeCostOfTSP(start, start, visited);
            minCost = Math.min(minCost, result);
        }
        return minCost;
    }

    private int computeCostOfTSP(Node now, Node startNode, Set<Integer> visited) {
        int minCost = INIT_VALUE;
        if (visited.size() == totalNode) {
            if (isNotVisited(now, startNode)) {
                return INIT_VALUE;
            }
            return now.cost + adjMetric[now.nodeId][startNode.nodeId];
        }
        for (int i = 0; i < totalNode; i++) {
            Node next = new Node(i, now.cost + adjMetric[now.nodeId][i]);
            if (isNotVisited(now, next) || visited.contains(i)) {
                continue;
            }
            visited.add(i);
            int result = computeCostOfTSP(next, startNode, visited);
            minCost = Math.min(minCost, result);
            visited.remove(i);
        }
        return minCost;
    }

    private boolean isNotVisited(Node now, Node next) {
        return adjMetric[now.nodeId][next.nodeId] == 0;
    }

    private static class Node {
        private final int nodeId;
        private final int cost;

        public Node(int nodeId, int cost) {
            this.nodeId = nodeId;
            this.cost = cost;
        }
    }

}
