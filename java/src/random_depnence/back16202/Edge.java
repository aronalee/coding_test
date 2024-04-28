// prob: https://www.acmicpc.net/problem/16202

package random_depnence.back16202;

import java.util.Objects;

public class Edge {

    private final int node1;
    private final int node2;
    private final int weight;

    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return node1 == edge.node1 && node2 == edge.node2 && weight == edge.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2, weight);
    }
}