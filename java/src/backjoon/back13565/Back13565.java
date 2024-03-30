// prob: https://www.acmicpc.net/problem/13565

package backjoon.back13565;

import java.util.List;

public class Back13565 {

    private static final int EMPTY = 0;
    private static final int BLOCKED = 1;
    private static final List<Point> DIRECTIONS = List.of(
            new Point(-1, 0),
            new Point(1, 0),
            new Point(0, -1),
            new Point(0, 1)
    );
    private int columnMax;
    private int rowMax;

    public boolean hasElectronicPath(int[][] map) {
        this.rowMax = map.length;
        this.columnMax = map[0].length;
        int[] outersides = map[0];
        boolean[][] visited = new boolean[rowMax][columnMax];
        for (int i = 0; i < outersides.length; i++) {
            if (visited[0][i] || outersides[i] == BLOCKED) {
                continue;
            }
            if (hasElectronicPath(visited, map, new Point(0, i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasElectronicPath(boolean[][] visited, int[][] map, Point point) {
        if (point.row == rowMax - 1) {
            return map[point.row][point.column] == EMPTY;
        }
        visited[point.row][point.column] = true;
        for (Point direction : DIRECTIONS) {
            Point next = new Point(point.row + direction.row, point.column + direction.column);
            if (isOverMap(next) || visited[next.row][next.column] || map[next.row][next.column] == BLOCKED) {
                continue;
            }
            if (hasElectronicPath(visited, map, next)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOverMap(Point next) {
        return next.row < 0 || next.row >= rowMax || next.column < 0 || next.column >= columnMax;
    }

    private static class Point {
        private final int row;
        private final int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

    }
}
