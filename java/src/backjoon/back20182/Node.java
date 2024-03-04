// prob: https://www.acmicpc.net/problem/20182

package backjoon.back20182;

public class Node {
    private final int id;

    private final int cost;

    public Node(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}
