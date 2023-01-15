package backjoon.back2146;

import java.util.LinkedList;
import java.util.Queue;

public class Back2146 {

    private final int[][] map;
    private final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public Back2146(int[][] map) {
        this.map = convertMapContainsLandId(map);
    }

    private int[][] convertMapContainsLandId(final int[][] map) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        int[][] mapFilledLandId = new int[map.length][map[0].length];
        int landId = 1;
        for (int y = 0; y < visited.length; y++) {
            for (int x = 0; x < visited[y].length; x++) {
                if (visited[y][x] || map[y][x] == 0) {
                    continue;
                }
                markingLand(map, visited, mapFilledLandId, landId, y, x);
                landId++;
            }
        }
        return mapFilledLandId;
    }

    private void markingLand(int[][] map, boolean[][] visited, int[][] mapFilledLandId, int landId,
        int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});
        mapFilledLandId[y][x] = landId;
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            for (int[] direction : DIRECTIONS) {
                int nextY = now[0] + direction[0];
                int nextX = now[1] + direction[1];
                if (nextY < 0 || nextY >= map.length || nextX < 0
                    || nextX >= map[nextY].length) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] == 0) {
                    continue;
                }
                visited[nextY][nextX] = true;
                mapFilledLandId[nextY][nextX] = landId;
                queue.add(new int[]{nextY, nextX});
            }
        }
    }

    public int getAnswer() {
        int minDistance = Integer.MAX_VALUE;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == 0) {
                    continue;
                }
                int distance = getMinDistance(y, x);
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }

    private int getMinDistance(int y, int x) {
        boolean[][] visited = new boolean[map.length][map[0].length];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(y, x, map[y][x], 0));
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (int[] direction : DIRECTIONS) {
                int nextY = now.y + direction[0];
                int nextX = now.x + direction[1];
                if (nextY < 0 || nextY >= map.length || nextX < 0
                    || nextX >= map[nextY].length) {
                    continue;
                }
                if (visited[nextY][nextX] || map[nextY][nextX] == now.landId) {
                    continue;
                }
                if (map[nextY][nextX] != 0 && map[nextY][nextX] != now.landId) {
                    return now.distance;
                }
                visited[nextY][nextX] = true;
                queue.add(new Node(nextY, nextX, now.landId, now.distance + 1));
            }
        }
        return Integer.MAX_VALUE;
    }

    private static class Node {

        private final int y;
        private final int x;
        private final int landId;
        private final int distance;

        public Node(int y, int x, int landId, int distance) {
            this.y = y;
            this.x = x;
            this.landId = landId;
            this.distance = distance;
        }
    }

}
