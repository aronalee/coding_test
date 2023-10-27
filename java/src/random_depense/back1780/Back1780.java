// prob: https://www.acmicpc.net/problem/1780

package random_depense.back1780;

import java.util.LinkedList;
import java.util.List;

public class Back1780 {
    private static List<Point> createSubStartPoints(Point start, Point end, int step) {
        List<Point> points = new LinkedList<>();
        for (int y = start.y; y < end.y; y += step) {
            for (int x = start.x; x < end.x; x += step) {
                points.add(Point.of(y, x));
            }
        }
        return points;
    }

    public int[] countOfSymbols(int[][] map) {
        int maxSize = map.length;
        Point start = Point.of(0, 0);
        Point end = Point.of(maxSize, maxSize);
        return countOfSymbols(map, start, end);
    }

    private int[] countOfSymbols(int[][] map, Point start, Point end) {
        int[] result = new int[3];
        int step = (end.y - start.y) / 3;
        if (end.y - start.y == 1 && end.x - start.x == 1) {
            result[map[start.y][start.x] + 1]++;
            return result;
        }
        List<Point> points = createSubStartPoints(start, end, step);
        for (Point subStart : points) {
            int[] temp = countOfSymbols(map, subStart, Point.of(subStart.y + step, subStart.x + step));
            for (int i = 0; i < result.length; i++) {
                result[i] += temp[i];
            }
        }
        return compressResult(result);
    }

    private int[] compressResult(int[] result) {
        for (int i = 0; i < result.length; i++) {
            // 9등분을 하기에 합이 9여야 압축
            if (result[i] == 9 && result[(i + 1) % 3] == 0 && result[(i + 2) % 3] == 0) {
                result[i] = 1;
                result[(i + 1) % 3] = 0;
                result[(i + 2) % 3] = 0;
                return result;
            }
        }
        return result;
    }


    private static class Point {
        private final int y;
        private final int x;

        private Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public static Point of(int y, int x) {
            return new Point(y, x);
        }
    }
}
