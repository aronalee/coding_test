// prob: https://school.programmers.co.kr/learn/courses/30/lessons/87694

package programmers.아이템줍기;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0},
    };
    private final int[][] RANGES_POINT = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1},
    };
    private final boolean[][] map = new boolean[102][102];

    public int solution(int[][] rectangles, int characterX, int characterY, int itemX, int itemY) {
        int[] start = new int[]{characterX * 2, characterY * 2};
        int[] end = new int[]{itemX * 2, itemY * 2};
        initMap(rectangles);
        return bfs(start, end);
    }

    private void initMap(final int[][] rectangles) {
        for (final int[] rectangle : rectangles) {
            int startX = rectangle[0] * 2;
            int startY = rectangle[1] * 2;
            int endX = rectangle[2] * 2;
            int endY = rectangle[3] * 2;
            for (int y = startY; y <= endY; y++) {
                for (int x = startX; x <= endX; x++) {
                    map[y][x] = true;
                }
            }
        }
    }

    private int bfs(final int[] start, final int[] end) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        visited[start[1]][start[0]] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.isEqualPoint(end)) {
                return now.distance / 2;
            }
            for (final int[] direction : DIRECTIONS) {
                int[] nextPoint = now.createNextPoint(direction);
                if (visited[nextPoint[1]][nextPoint[0]]) {
                    continue;
                }
                if (!map[nextPoint[1]][nextPoint[0]]) {
                    continue;
                }
                if (!isSurfacePoint(nextPoint)) {
                    continue;
                }
                visited[nextPoint[1]][nextPoint[0]] = true;
                queue.add(new Node(
                    nextPoint, now.distance + 1
                ));
            }
        }
        throw new IllegalArgumentException();
    }

    private boolean isSurfacePoint(final int[] point) {
        int count = 0;
        for (final int[] range : RANGES_POINT) {
            int nextX = point[0] + range[0];
            int nextY = point[1] + range[1];
            if (isNotRangePointInMap(new int[]{nextX, nextY})) {
                continue;
            }
            if (map[nextY][nextX]) {
                count++;
            }
        }
        return count != 8;
    }

    private boolean isNotRangePointInMap(int[] point) {
        return point[1] < 0 || point[1] >= map.length
            || point[0] < 0 || point[0] >= map[point[1]].length;
    }

    private static class Node {

        private final int[] point;
        private final int distance;

        public Node(final int[] point, final int distance) {
            this.point = point;
            this.distance = distance;
        }

        public boolean isEqualPoint(int[] point) {
            return this.point[0] == point[0] && this.point[1] == point[1];
        }

        public int[] createNextPoint(int[] direction) {
            return new int[]{
                point[0] + direction[0],
                point[1] + direction[1]
            };
        }
    }
}
