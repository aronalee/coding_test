// prob: https://school.programmers.co.kr/learn/courses/30/lessons/1829

package programmers.카카오프렌즈_컬러링북;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] DISTANCES = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        for (int y = 0; y < picture.length; y++) {
            for (int x = 0; x < picture[y].length; x++) {
                if (picture[y][x] == 0) {
                    visited[y][x] = true;
                    continue;
                }
                if (visited[y][x]) {
                    continue;
                }
                int area = bfs(new int[]{y, x}, picture, visited);
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(final int[] start, final int[][] picture, final boolean[][] visited) {
        int area = 1;
        int color = picture[start[0]][start[1]];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            for (final int[] distance : DISTANCES) {
                int nextY = now[0] + distance[0];
                int nextX = now[1] + distance[1];
                if (nextY < 0 || nextY >= picture.length || nextX < 0
                    || nextX >= picture[nextY].length) {
                    continue;
                }
                if (visited[nextY][nextX] || picture[nextY][nextX] != color) {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.add(new int[]{nextY, nextX});
                area++;
            }
        }
        return area;
    }
}
