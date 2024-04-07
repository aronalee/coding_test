// prob: https://www.acmicpc.net/problem/14923

package random_depnence.back14923;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Back14923 {
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int WALL = 1;
    private final int[][] map;


    public Back14923(int[][] map) {
        this.map = map;
    }

    public int findPathMinCost(Point start, Point end) {
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getCost));
        int[][][] visited = new int[map.length][map[0].length][2];
        for (int[][] row : visited) {
            for (int[] col : row) {
                col[0] = EMPTY;
                col[1] = EMPTY;
            }
        }
        queue.add(new Node(start, 0, false));
        visited[start.getY()][start.getX()][0] = 0;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.point.equals(end)) {
                return now.getCost();
            }
            for (int[] direction : DIRECTIONS) {
                int nextY = now.point.getY() + direction[0];
                int nextX = now.point.getX() + direction[1];
                if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map[0].length) {
                    continue;
                }
                if (map[nextY][nextX] == WALL && now.isUsedMagic) {
                    continue;
                }
                int nextCost = now.cost + 1;
                if (visited[nextY][nextX][now.isUsedMagic ? 1 : 0] <= nextCost) {
                    continue;
                }
                Node next = new Node(Point.of(nextY, nextX), nextCost, now.isUsedMagic);
                if (map[nextY][nextX] == WALL) {
                    next = new Node(Point.of(nextY, nextX), nextCost, true);
                }
                visited[nextY][nextX][now.isUsedMagic ? 1 : 0] = nextCost;
                queue.add(next);
            }
        }
        throw new IllegalArgumentException("not found path");
    }


    private class Node {
        private final Point point;
        private final int cost;
        private final boolean isUsedMagic;

        private Node(Point point, int cost, boolean isUsedMagic) {
            this.point = point;
            this.cost = cost;
            this.isUsedMagic = isUsedMagic;
        }

        public int getCost() {
            return cost;
        }

    }
}
