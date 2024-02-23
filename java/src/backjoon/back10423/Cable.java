// prob: https://www.acmicpc.net/problem/10423

package backjoon.back10423;

public class Cable {
    private final int city1;
    private final int city2;

    private final int length;

    private Cable(int city1, int city2, int length) {
        this.city1 = city1;
        this.city2 = city2;
        this.length = length;
    }

    public static Cable of(int city1, int city2, int weight) {
        return new Cable(city1, city2, weight);
    }

    public int getCity1() {
        return city1;
    }

    public int getCity2() {
        return city2;
    }

    public int getLength() {
        return length;
    }
}
