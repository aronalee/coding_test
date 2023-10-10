// prob: https://www.acmicpc.net/problem/17396

package backjoon.back17396;

import java.util.*;

public class Back17396 {
    public static final long NOT_VISITED = Long.MAX_VALUE;
    private final List<List<Node>> adjList;

    public Back17396(List<List<Node>> adjList) {
        this.adjList = adjList;
    }

    public long getMinCostNotViewedStatus(int src, int dst) {
        long[] minCosts = new long[adjList.toArray().length];
        Arrays.fill(minCosts, NOT_VISITED);
        minCosts[src] = 0;
        return dijstra(minCosts, src, dst);
    }

    private long dijstra(long[] minCosts, int src, int dst) {
        boolean[] visited = new boolean[minCosts.length];
        Queue<Status> queue = new PriorityQueue<>(Comparator.comparingLong(o -> o.cost));
        queue.add(Status.of(src, 0));
        while (!queue.isEmpty()) {
            Status now = queue.remove();
            if (visited[now.id]) {
                continue;
            }
            visited[now.id] = true;
            for (Node node : adjList.get(now.id)) {
                if ((node.getNext() != dst && node.isViewed()) || node.getCost() + now.cost >= minCosts[node.getNext()]) {
                    continue;
                }
                minCosts[node.getNext()] = node.getCost() + now.cost;
                queue.add(Status.of(node.getNext(), node.getCost() + now.cost));
            }
        }
        return minCosts[dst];
    }

    private static class Status {
        private final int id;
        private final long cost;

        private Status(int id, long cost) {
            this.id = id;
            this.cost = cost;
        }

        public static Status of(int id, long cost) {
            return new Status(id, cost);
        }
    }
}
