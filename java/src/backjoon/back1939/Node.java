// prob: https://www.acmicpc.net/problem/1939

package backjoon.back1939;

public class Node {
    private final int id;
    private final int weight;

    private Node(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public static Node of(int id, int weight) {
        return new Node(id, weight);
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
