// prob: https://www.acmicpc.net/problem/14621

package backjoon.back14621;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Back14621 {
    public int computeSumOfMinDistance(List<Character> nodes, List<Edge> edge) {
        return createMST(nodes, edge).stream().mapToInt(Edge::getDistance).sum();
    }

    private List<Edge> createMST(List<Character> nodes, List<Edge> edges) {
        int[] parents = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++) {
            parents[i] = i;
        }
        edges.sort(Comparator.comparingInt(Edge::getDistance));
        List<Edge> mst = new LinkedList<>();
        for (Edge edge : edges) {
            if (isEqualInfo(edge.getNode1(), edge.getNode2(), nodes) || isEqualParents(edge.getNode1(), edge.getNode2(), parents)) {
                continue;
            }
            union(edge.getNode1(), edge.getNode2(), parents);
            mst.add(edge);
        }
        if (isNotMST(parents)) {
            throw new IllegalStateException("not found MST");
        }
        return mst;
    }

    private boolean isEqualInfo(int node1, int node2, List<Character> nodes) {
        return nodes.get(node1).equals(nodes.get(node2));
    }

    private boolean isEqualParents(int node1, int node2, int[] parents) {
        return findParent(node1, parents) == findParent(node2, parents);
    }

    private int findParent(int node, int[] parents) {
        if (parents[node] == node) {
            return node;
        }
        return findParent(parents[node], parents);
    }

    private void union(int node1, int node2, int[] parents) {
        int parent1;
        int parent2;
        while ((parent1 = findParent(node1, parents)) != (parent2 = findParent(node2, parents))) {
            parents[parent1] = parent2;
        }
    }

    private boolean isNotMST(int[] parents) {
        int parent = findParent(0, parents);
        for (int node : parents) {
            if (findParent(node, parents) != parent) {
                return true;
            }
        }
        return false;
    }
}
