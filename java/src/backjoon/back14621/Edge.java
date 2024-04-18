// prob: https://www.acmicpc.net/problem/14621

package backjoon.back14621;

public class Edge {
    private final int node1;
    private final int node2;
    private final int distance;

    public Edge(int node1, int node2, int distance) {
        this.node1 = node1;
        this.node2 = node2;
        this.distance = distance;
    }

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getDistance() {
        return distance;
    }
}
