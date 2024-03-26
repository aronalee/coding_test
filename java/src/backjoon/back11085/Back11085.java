// prob: https://www.acmicpc.net/problem/11085

package backjoon.back11085;

import java.util.List;
import java.util.NoSuchElementException;

public class Back11085 {

    private final List<Edge> edges;
    private int[] unionedPath;

    public Back11085(List<Edge> edgesBySortedWidth) {
        this.edges = edgesBySortedWidth;
    }

    public int findMaxWidth(int nodesTotal, int backCapital, int cubeCapital) {
        this.unionedPath = new int[nodesTotal];
        for (int i = 0; i < nodesTotal; i++) {
            unionedPath[i] = i;
        }
        for (Edge edge : edges) {
            int from = edge.getFrom();
            int to = edge.getTo();
            int width = edge.getWidth();
            if (find(from) != find(to)) {
                union(from, to);
            }
            if (find(backCapital) == find(cubeCapital)) {
                return width;
            }
        }
        throw new NoSuchElementException("not reachable backCapital to cubeCapital");
    }

    private int find(int node) {
        if (unionedPath[node] == node) {
            return node;
        }
        return find(unionedPath[node]);
    }

    private void union(int from, int to) {
        int fromOfParent;
        int toOfParent;
        while ((fromOfParent = find(from)) != (toOfParent = find(to))) {
            unionedPath[fromOfParent] = toOfParent;
        }
    }
}
