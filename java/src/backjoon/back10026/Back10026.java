// prob: https://www.acmicpc.net/problem/10026

package backjoon.back10026;

public class Back10026 {

    private final int[][] DIRECTIONS = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int countAreas(COLOR[][] map) {
        int count = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int y = 0; y < visited.length; y++) {
            for (int x = 0; x < visited.length; x++) {
                if (visited[y][x]) {
                    continue;
                }
                markVisited(map, visited, Point.of(y, x), map[y][x]);
                count++;
            }
        }
        return count;
    }

    public int countAreasRedAndGreenEqual(COLOR[][] map) {
        int count = 0;
        boolean[][] visited = new boolean[map.length][map[0].length];
        for (int y = 0; y < visited.length; y++) {
            for (int x = 0; x < visited.length; x++) {
                if (visited[y][x]) {
                    continue;
                }
                count++;
                if (map[y][x] == COLOR.RED || map[y][x] == COLOR.GREEN) {
                    markVisited(map, visited, Point.of(y, x), COLOR.RED, COLOR.GREEN);
                    continue;
                }
                markVisited(map, visited, Point.of(y, x), map[y][x]);
            }
        }
        return count;
    }

    private void markVisited(COLOR[][] map, boolean[][] visited, Point point, COLOR... colors) {
        visited[point.y][point.x] = true;
        for (int[] direction : DIRECTIONS) {
            Point nextPoint = Point.of(point.y + direction[0], point.x + direction[1]);
            if (isOutOfMap(map, nextPoint) || isVisited(nextPoint, visited)) {
                continue;
            }
            if (!hasContainsColor(map, nextPoint, colors)) {
                continue;
            }
            markVisited(map, visited, nextPoint, colors);
        }
    }

    private boolean isOutOfMap(COLOR[][] map, Point point) {
        return point.y < 0 || point.y >= map.length || point.x < 0 || point.x >= map[0].length;
    }

    private boolean isVisited(Point point, boolean[][] visited) {
        return visited[point.y][point.x];
    }

    private boolean hasContainsColor(COLOR[][] map, Point point, COLOR[] colors) {
        for (COLOR color : colors) {
            if (map[point.y][point.x] == color) {
                return true;
            }
        }
        return false;
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
