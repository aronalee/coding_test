// prob: https://school.programmers.co.kr/learn/courses/30/lessons/154540

package programmers.무인도_여행;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private final int NOT_LAND = -1;

    public int[] solution(String[] maps) {
        List<Integer> counts = createCounts(maps);
        if (counts.size() == 0) {
            return new int[]{-1};
        }
        return countsToArray(counts);
    }

    private List<Integer> createCounts(String[] maps) {
        List<Integer> counts = new ArrayList<>();
        int[][] mapOfDay = createMapOfDay(maps);
        boolean[][] visited = createVisited(maps);
        for (int y = 0; y < mapOfDay.length; y++) {
            for (int x = 0; x < mapOfDay[y].length; x++) {
                if (isNotGoToPoint(visited, mapOfDay, new int[]{y, x})) {
                    continue;
                }
                int count = countDayAndMarkVisited(visited, mapOfDay, new int[]{y, x});
                counts.add(count);
            }
        }
        return counts;
    }

    private int[] countsToArray(List<Integer> counts) {
        int[] answer = new int[counts.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = counts.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private int countDayAndMarkVisited(
        boolean[][] visited,
        int[][] foodMaps,
        int[] point
    ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(point);
        visited[point[0]][point[1]] = true;
        int count = foodMaps[point[0]][point[1]];
        int[][] distances = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] now = queue.remove();
            for (int[] distance : distances) {
                int nextY = now[0] + distance[0];
                int nextX = now[1] + distance[1];
                if (nextY < 0 | nextY >= foodMaps.length
                    || nextX >= foodMaps[nextY].length || nextX < 0) {
                    continue;
                }
                if (isNotGoToPoint(visited, foodMaps, new int[]{nextY, nextX})) {
                    continue;
                }
                visited[nextY][nextX] = true;
                count += foodMaps[nextY][nextX];
                queue.add(new int[]{nextY, nextX});
            }
        }
        return count;
    }

    private boolean isNotGoToPoint(
        boolean[][] visited,
        int[][] foodMaps,
        int[] point
    ) {
        int y = point[0];
        int x = point[1];
        return visited[y][x] || foodMaps[y][x] == NOT_LAND;
    }

    private int[][] createMapOfDay(String[] maps) {
        int[][] foodMaps = new int[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            foodMaps[i] = new int[maps[i].length()];
            char[] foodLands = maps[i].toCharArray();
            for (int j = 0; j < foodLands.length; j++) {
                if (foodLands[j] == 'X') {
                    foodMaps[i][j] = NOT_LAND;
                    continue;
                }
                foodMaps[i][j] = Character.getNumericValue(foodLands[j]);
            }
        }
        return foodMaps;
    }

    private boolean[][] createVisited(String[] maps) {
        boolean[][] visited = new boolean[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            visited[i] = new boolean[maps[i].length()];
        }
        return visited;
    }
}
