// prob: https://www.acmicpc.net/problem/15806

package backjoon.back15806;

import java.util.Objects;

public class Point {
    private final int y;
    private final int x;

    public Point(int y, int x) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return y == point.y && x == point.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
