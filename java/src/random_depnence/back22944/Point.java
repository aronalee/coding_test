// prob: https://www.acmicpc.net/problem/22944

package random_depnence.back22944;

public class Point {
    public static final Point EMPTY = new Point(-1, -1);
    public static int DANGER_POINT = 0;
    public static int SAFE_POINT = 1;
    public static int UMBRELLA_POINT = 2;
    private final int row;
    private final int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean isSafe(int[][] map) {
        return map[row][column] == SAFE_POINT;
    }

    public boolean isUmbrella(int[][] map) {
        return map[row][column] == UMBRELLA_POINT;
    }

    public Point move(int[] direction) {
        return new Point(row + direction[0], column + direction[1]);
    }

    public boolean isOverMap(int[][] map) {
        return row < 0 || column < 0 || row >= map.length || column >= map[0].length;
    }

    public int getValueInMap(int[][] map) {
        return map[row][column];
    }

    public void fillValue(int[][] minCounts, int count) {
        minCounts[row][column] = count;
    }
}
