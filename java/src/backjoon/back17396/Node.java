// prob: https://www.acmicpc.net/problem/17396

package backjoon.back17396;

public class Node {
    private final int next;
    private final int cost;
    private final boolean isViewed;

    private Node(int next, int cost, boolean isViewed) {
        this.next = next;
        this.cost = cost;
        this.isViewed = isViewed;
    }

    public static Node of(int dst, int cost, boolean isViewed) {
        return new Node(dst, cost, isViewed);
    }

    public int getNext() {
        return next;
    }

    public int getCost() {
        return cost;
    }

    public boolean isViewed() {
        return isViewed;
    }
}
