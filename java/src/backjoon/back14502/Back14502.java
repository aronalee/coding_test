// prob: https://www.acmicpc.net/problem/14502

package backjoon.back14502;

import static backjoon.back14502.AreaStatus.BLOCK;
import static backjoon.back14502.AreaStatus.EMPTY;
import static backjoon.back14502.AreaStatus.VIRUS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Back14502 {

    private static final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private int maxHeight;
    private int maxWidth;
    private AreaStatus[][] map;

    public int getMaxSafetyArea(AreaStatus[][] map, int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.map = map;
        List<List<Point>> combinations = createCombinations();
        int maxArea = 0;
        for (List<Point> combination : combinations) {
            int safetyArea = getSafetyArea(map, combination);
            maxArea = Math.max(maxArea, safetyArea);
        }
        return maxArea;
    }

    private List<List<Point>> createCombinations() {
        List<Point> empties = new ArrayList<>();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] != EMPTY) {
                    continue;
                }
                empties.add(new Point(y, x));
            }
        }
        List<List<Point>> combinations = new ArrayList<>();
        addCombinations(combinations, empties, 0, new LinkedList<>());
        return combinations;
    }

    private void addCombinations(List<List<Point>> combinations,
        List<Point> empties,
        int start,
        List<Point> combination) {
        if (combination.size() == 3) {
            combinations.add(new LinkedList<>(combination));
            return;
        }
        for (int i = start; i < empties.size(); i++) {
            combination.add(empties.get(i));
            addCombinations(combinations, empties, i + 1, combination);
            combination.remove(empties.get(i));
        }
    }

    private int getSafetyArea(
        AreaStatus[][] map,
        List<Point> selectedBlocks
    ) {
        int safetyArea = 0;
        boolean[][] visited = new boolean[maxHeight][maxWidth];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                Point now = new Point(y, x);
                if (selectedBlocks.contains(now) || map[y][x] != EMPTY || visited[y][x]) {
                    continue;
                }
                for (Point point : selectedBlocks) {
                    map[point.y][point.x] = BLOCK;
                }
                safetyArea += bfs(visited, now);
                for (Point point : selectedBlocks) {
                    map[point.y][point.x] = EMPTY;
                }
            }
        }
        return safetyArea;
    }

    private int bfs(
        boolean[][] visited,
        Point start
    ) {
        int count = 1;
        boolean virusFlag = false;
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        visited[start.y][start.x] = true;
        while (!queue.isEmpty()) {
            Point now = queue.remove();
            for (int[] direction : DIRECTIONS) {
                int nextY = now.y + direction[0];
                int nextX = now.x + direction[1];
                if (nextY < 0 || nextY >= maxHeight || nextX < 0
                    || nextX >= maxWidth) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] != EMPTY) {
                    if (map[nextY][nextX] == VIRUS) {
                        virusFlag = true;
                    }
                    continue;
                }
                count++;
                visited[nextY][nextX] = true;
                queue.add(new Point(nextY, nextX));
            }
        }
        if (virusFlag) {
            return 0;
        }
        return count;
    }

    private static class Point {

        private final int y;
        private final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return y == point.y && x == point.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
