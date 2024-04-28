// prob: https://www.acmicpc.net/problem/16202

package random_depnence.back16202;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Back16202 {
    private final int nodeTotal;
    private final List<Edge> edges;
    private final int turnTotal;

    public Back16202(int nodeTotal, List<Edge> edges, int turnTotal) {
        this.nodeTotal = nodeTotal;
        this.edges = edges;
        this.turnTotal = turnTotal;
    }

    public List<Integer> computeAllTurn() {
        List<Integer> scores = new LinkedList<>();
        Set<Edge> excludedEdges = new HashSet<>();
        for (int turn = 0; turn < turnTotal; turn++) {
            List<Edge> mst = createMST(excludedEdges);
            if (mst == null) {
                scores.add(0);
                break;
            }
            scores.add(mst.stream().mapToInt(Edge::getWeight).sum());
            excludedEdges.add(mst.get(0));
        }
        while (scores.size() < turnTotal) {
            scores.add(0);
        }
        return scores;
    }

    private List<Edge> createMST(Set<Edge> excludedEdges) {
        List<Edge> mst = new LinkedList<>();
        int[] parent = new int[nodeTotal];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (Edge edge : edges) {
            if (excludedEdges.contains(edge) || isCycle(parent, edge)) {
                continue;
            }
            union(edge.getNode1(), edge.getNode2(), parent);
            mst.add(edge);
        }
        if (mst.size() != nodeTotal - 1) {
            return null;
        }
        for (int i = 1; i < nodeTotal; i++) {
            union(i - 1, i, parent);
        }
        return mst;
    }

    private boolean isCycle(int[] parent, Edge edge) {
        int node1 = edge.getNode1();
        int node2 = edge.getNode2();
        return find(parent, node1) == find(parent, node2);
    }

    private int find(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent, parent[node]);
    }

    private void union(int node1, int node2, int[] parent) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        parent[root2] = root1;
    }
}
