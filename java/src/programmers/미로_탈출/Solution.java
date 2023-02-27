// prob: https://school.programmers.co.kr/learn/courses/30/lessons/159993

package programmers.미로_탈출;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    private int maxHeight;
    private int maxWidth;
    private char[][] infoMap;

    public int solution(String[] maps) {
        maxHeight = maps.length;
        maxWidth = maps[0].length();
        initInfoMap(maps);
        int[] start = findPositionAboutSymbol(infoMap, 'S');
        int[] end = findPositionAboutSymbol(infoMap, 'E');
        int[] lever = findPositionAboutSymbol(infoMap, 'L');
        int distanceAboutStartToLever;
        int distanceAboutLeverToEnd;
        try {
            distanceAboutStartToLever = findMinDistance(start, lever);
            distanceAboutLeverToEnd = findMinDistance(lever, end);
        } catch (IllegalArgumentException e) {
            return -1;
        }
        return distanceAboutStartToLever + distanceAboutLeverToEnd;

    }

    private int findMinDistance(int[] src, int[] dst) {
        boolean[][] visited = new boolean[maxHeight][maxWidth];
        Queue<Point> queue = new LinkedList<>();
        queue.add(Point.of(src[0], src[1], 0));
        visited[src[0]][src[1]] = true;
        while (!queue.isEmpty()) {
            Point now = queue.remove();
            if (now.y == dst[0] && now.x == dst[1]) {
                return now.distance;
            }
            for (int[] direction : DIRECTIONS) {
                int nextY = now.y + direction[0];
                int nextX = now.x + direction[1];
                if (nextY < 0 || nextY >= maxHeight || nextX < 0 || nextX >= maxWidth) {
                    continue;
                }
                if (visited[nextY][nextX] || infoMap[nextY][nextX] == 'X') {
                    continue;
                }
                visited[nextY][nextX] = true;
                queue.add(Point.of(nextY, nextX, now.distance + 1));
            }
        }
        throw new IllegalArgumentException("Not Found root about src to dst");
    }

    private int[] findPositionAboutSymbol(char[][] infoMap, char symbol) {
        for (int y = 0; y < infoMap.length; y++) {
            for (int x = 0; x < infoMap[y].length; x++) {
                if (infoMap[y][x] == symbol) {
                    return new int[]{y, x};
                }
            }
        }
        throw new IllegalArgumentException("Not Match Symbol");
    }

    private void initInfoMap(String[] maps) {
        infoMap = new char[maxHeight][maxWidth];
        for (int y = 0; y < maps.length; y++) {
            String line = maps[y];
            char[] charArray = line.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                char value = charArray[x];
                infoMap[y][x] = value;
            }
        }
    }

    private static class Point {

        private final int y;
        private final int x;
        private final int distance;

        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }

        public static Point of(int y, int x, int distance) {
            return new Point(y, x, distance);
        }

    }
}
