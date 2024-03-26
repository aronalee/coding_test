// prob: https://www.acmicpc.net/problem/11085

package backjoon.back11085;

public class Edge {
    private final int from;

    private final int to;

    private final int width;

    public Edge(int from, int to, int width) {
        this.from = from;
        this.to = to;
        this.width = width;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public int getWidth() {
        return width;
    }
}