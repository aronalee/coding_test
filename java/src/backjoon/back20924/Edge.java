// https://www.acmicpc.net/problem/20924

package backjoon.back20924;

public class Edge {
    private final int dstNodeId;
    private final int distance;

    private Edge(int dstNodeId, int distance) {
        this.dstNodeId = dstNodeId;
        this.distance = distance;
    }

    public static Edge of(int dstNodeId, int distance) {
        return new Edge(dstNodeId, distance);
    }

    public int getDstNodeId() {
        return dstNodeId;
    }

    public int getDistance() {
        return distance;
    }
}
