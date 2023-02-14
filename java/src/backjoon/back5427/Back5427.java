// prob: https://www.acmicpc.net/problem/5427

package backjoon.back5427;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back5427 {

    private final int[][] DISTANCES = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    private static boolean isOutBuilding(int height, int width, int nextY, int nextX) {
        return nextY < 0 || nextY >= height || nextX < 0 || nextX >= width;
    }

    public int getMinTime(
        BuildingStatus[][] buildingStatuses,
        List<int[]> startBurnPoints,
        int[] person
    ) {
        int height = buildingStatuses.length;
        int width = buildingStatuses[0].length;
        int[][] burnTimes = createBurnTimes(buildingStatuses, startBurnPoints, height, width);
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(person[0], person[1], 0));
        boolean[][] visited = new boolean[height][width];
        visited[person[0]][person[1]] = true;
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            int nextTime = now.time + 1;
            for (int[] distance : DISTANCES) {
                int nextY = now.y + distance[0];
                int nextX = now.x + distance[1];
                if (isOutBuilding(height, width, nextY, nextX)) {
                    return nextTime;
                }
                if (visited[nextY][nextX] || burnTimes[nextY][nextX] <= nextTime
                    || buildingStatuses[nextY][nextX] != BuildingStatus.EMPTY) {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.add(new Node(nextY, nextX, now.time + 1));
            }
        }
        return -1;
    }

    private int[][] createBurnTimes(
        BuildingStatus[][] buildingStatuses,
        List<int[]> startBurnPoints,
        int height,
        int width
    ) {
        int[][] burnTimes = new int[height][width];
        for (int[] burnTime : burnTimes) {
            Arrays.fill(burnTime, Integer.MAX_VALUE);
        }
        boolean[][] visited = new boolean[height][width];
        Queue<Node> queue = new LinkedList<>();
        for (int[] point : startBurnPoints) {
            queue.add(new Node(point[0], point[1], 0));
            visited[point[0]][point[1]] = true;
        }
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (int[] distance : DISTANCES) {
                int nextY = now.y + distance[0];
                int nextX = now.x + distance[1];
                if (isOutBuilding(height, width, nextY, nextX)) {
                    continue;
                }
                if (visited[nextY][nextX]
                    || buildingStatuses[nextY][nextX] != BuildingStatus.EMPTY) {
                    continue;
                }
                visited[nextY][nextX] = true;
                burnTimes[nextY][nextX] = now.time + 1;
                queue.add(new Node(nextY, nextX, now.time + 1));
            }
        }
        return burnTimes;
    }

    private static class Node {

        private final int y;
        private final int x;
        private final int time;

        public Node(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
}
