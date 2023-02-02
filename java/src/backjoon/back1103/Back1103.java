// prob: https://www.acmicpc.net/problem/1103

package backjoon.back1103;

public class Back1103 {

    private final int[][] map;
    private final boolean[][] visited;
    private final int[][] DISTANCES = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };


    public Back1103(int[][] map, boolean[][] visited) {
        this.map = map;
        this.visited = visited;
    }

    public int createAnswer() {
        int[][][] maxCosts = new int[DISTANCES.length][map.length][map[0].length];
        Node start = new Node(0, 0);
        visited[start.y][start.x] = true;
        return dfs(start, maxCosts);
    }

    private int dfs(Node now, int[][][] maxCosts) {
        int jumpSize = map[now.y][now.x];
        for (int i = 0; i < DISTANCES.length; i++) {
            int[] distance = DISTANCES[i];
            int nextY = now.y + distance[0] * jumpSize;
            int nextX = now.x + distance[1] * jumpSize;
            if (nextY < 0 || nextY >= visited.length ||
                nextX < 0 || nextX >= visited[nextY].length
                || maxCosts[i][now.y][now.x] != STATUS.EMPTY.value()
                || map[nextY][nextX] == STATUS.HOLE.value()) {
                continue;
            }
            if (visited[nextY][nextX]) {
                maxCosts[i][nextY][nextX] = STATUS.CYCLE.value();
                continue;
            }
            visited[nextY][nextX] = true;
            maxCosts[i][now.y][now.x] = dfs(new Node(nextY, nextX), maxCosts);
            visited[nextY][nextX] = false;
        }
        return getMaxCost(now, maxCosts);
    }

    private int getMaxCost(Node now, int[][][] maxCosts) {
        int maxCost = 0;
        for (int[][] cost : maxCosts) {
            maxCost = Math.max(maxCost, cost[now.y][now.x]);
        }
        if (maxCost == STATUS.CYCLE.value()) {
            return maxCost;
        }
        return maxCost + 1;
    }

    private static class Node {

        private final int y;
        private final int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
