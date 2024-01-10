// https://www.acmicpc.net/problem/20924

package backjoon.back20924;

import java.util.List;

public class Back20924 {

    private final List<List<Edge>> adjList;

    public Back20924(List<List<Edge>> adjList) {
        this.adjList = adjList;
    }

    public GigaNodeInfo findGigaNodeInfo(boolean[] visited, int r) {
        visited[r] = true;
        if (adjList.get(r).size() != 1)
            return new GigaNodeInfo(0, r);
        Edge nextEdge = adjList.get(r).get(0);
        return getPoleLength(visited, nextEdge.getDstNodeId(), nextEdge.getDistance());
    }

    public int findMaximumLeafLength(boolean[] visited, int gigaNodeId) {
        return findMaximumLeafLengthUsingDFS(visited, gigaNodeId);
    }

    private GigaNodeInfo getPoleLength(boolean[] visited, int r, int acc) {
        visited[r] = true;
        if (adjList.get(r).size() > 2) {
            return new GigaNodeInfo(acc, r);
        }
        for (Edge edge : adjList.get(r)) {
            if (visited[edge.getDstNodeId()])
                continue;
            return getPoleLength(visited, edge.getDstNodeId(), edge.getDistance() + acc);
        }
        return new GigaNodeInfo(acc, r);
    }

    private int findMaximumLeafLengthUsingDFS(boolean[] visited, int gigaNodeId) {
        int maxLeafLength = 0;
        for (Edge edge : adjList.get(gigaNodeId)) {
            if (visited[edge.getDstNodeId()]) {
                continue;
            }
            visited[edge.getDstNodeId()] = true;
            maxLeafLength = Math.max(maxLeafLength, findMaximumLeafLengthUsingDFS(visited, edge.getDstNodeId()) + edge.getDistance());
        }
        return maxLeafLength;
    }

}
