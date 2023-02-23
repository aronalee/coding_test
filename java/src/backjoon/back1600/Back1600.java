// prob: https://www.acmicpc.net/problem/1600

package backjoon.back1600;

import java.util.LinkedList;
import java.util.Queue;

public class Back1600 {

    private final static int[][] DIRECTIONS_OF_CROSS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private final static int[][] DIRECTIONS_OF_JUMP = new int[][]{
        {2, 1}, {1, 2}, {2, -1}, {-1, 2}, {-2, 1}, {1, -2}, {-2, -1}, {-1, -2}
    };
    private final int W;
    private final int H;
    private final int[][] map;

    public Back1600(int w, int h, int[][] map) {
        W = w;
        H = h;
        this.map = map;
    }

    public int getAnswer(int k) {
        boolean[][][] visited = new boolean[k + 1][H][W];
        int dstY = H - 1;
        int dstX = W - 1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(Node.of(0, 0, 0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (now.y == dstY && now.x == dstX) {
                return now.distance;
            }
            addNextNodes(visited[now.counterOfJumping],
                queue,
                now,
                DIRECTIONS_OF_CROSS,
                now.counterOfJumping
            );
            if (now.counterOfJumping + 1 > k) {
                continue;
            }
            addNextNodes(visited[now.counterOfJumping + 1],
                queue,
                now,
                DIRECTIONS_OF_JUMP,
                now.counterOfJumping + 1
            );
        }
        return -1;
    }

    private void addNextNodes(boolean[][] visited,
        Queue<Node> queue,
        Node now,
        int[][] DIRECTIONS,
        int counterOfJumping) {
        for (int[] direction : DIRECTIONS) {
            int nextY = now.y + direction[0];
            int nextX = now.x + direction[1];
            if (isOverRangeOfMap(nextY, nextX)) {
                continue;
            }
            if (visited[nextY][nextX]
                || map[nextY][nextX] == 1) {
                continue;
            }
            visited[nextY][nextX] = true;
            queue.add(Node.of(nextY, nextX, now.distance + 1, counterOfJumping));
        }
    }

    private boolean isOverRangeOfMap(int nextY, int nextX) {
        return nextY < 0 || nextY >= H || nextX < 0 || nextX >= W;
    }

    private static class Node {

        private final int y;
        private final int x;
        private final int distance;
        private final int counterOfJumping;

        public Node(int y, int x, int distance, int counterOfJumping) {
            this.y = y;
            this.x = x;
            this.distance = distance;
            this.counterOfJumping = counterOfJumping;
        }

        public static Node of(int y, int x, int distance, int counterOfJumping) {
            return new Node(y, x, distance, counterOfJumping);
        }
    }
}
