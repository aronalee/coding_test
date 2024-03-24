// prob: https://www.acmicpc.net/problem/8983

package backjoon.back8983;

public class Point {
    private final int y;
    private final int x;

    private Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static Point of(int y, int x) {
        return new Point(y, x);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
