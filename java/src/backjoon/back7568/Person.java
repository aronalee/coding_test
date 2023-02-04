// prob: https://www.acmicpc.net/problem/7568

package backjoon.back7568;

public class Person {

    private final int id;
    private final int weight;
    private final int height;

    private Person(int id, int weight, int height) {
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public static Person of(int id, int weight, int height) {
        return new Person(id, weight, height);
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

}
