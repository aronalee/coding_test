// prob: https://school.programmers.co.kr/learn/courses/30/lessons/87377

package programmers.교점에별만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public String[] solution(int[][] line) {
        List<long[]> points = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            int[] func1 = line[i];
            for (int j = i + 1; j < line.length; j++) {
                int[] func2 = line[j];
                try {
                    points.add(getCrossPoint(func1, func2));
                } catch (IllegalArgumentException expected) {
                    // 두 일차함수가 평행하거나 교점이 실수인 경우. just continue.
                }
            }
        }
        long minY = Long.MAX_VALUE;
        long minX = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        long maxX = Long.MIN_VALUE;
        for (final long[] point : points) {
            minX = Math.min(minX, point[0]);
            minY = Math.min(minY, point[1]);
            maxX = Math.max(maxX, point[0]);
            maxY = Math.max(maxY, point[1]);
        }
        int sizeMapY = (int) (Math.abs(maxY - minY + 1));
        int sizeMapX = (int) (Math.abs(maxX - minX + 1));
        char[][] map = new char[sizeMapY][sizeMapX];
        for (final char[] chars : map) {
            Arrays.fill(chars, '.');
        }
        fillInStarByMap(points, minY, minX, map);
        return convertAnswerFormat(map);
    }

    private long[] getCrossPoint(int[] func1, int[] func2) {
        double x1 = func1[0];
        double y1 = func1[1];
        double c1 = func1[2];
        double x2 = func2[0];
        double y2 = func2[1];
        double c2 = func2[2];
        if (x1 * y2 - y1 * x2 == 0) {
            throw new IllegalArgumentException();
        }
        double crossX = (y1 * c2 - c1 * y2) / (x1 * y2 - y1 * x2);
        double crossY = (c1 * x2 - x1 * c2) / (x1 * y2 - y1 * x2);
        if (crossX % 1 != 0 || crossY % 1 != 0) {
            throw new IllegalArgumentException();
        }
        return new long[]{(long) crossX, (long) crossY};
    }

    private void fillInStarByMap(final List<long[]> points, final long minY, final long minX,
        final char[][] map) {
        for (final long[] point : points) {
            int x = (int) (point[0] - minX);
            int y = (int) (point[1] - minY);
            map[y][x] = '*';
        }
    }

    private String[] convertAnswerFormat(final char[][] map) {
        String[] answer = new String[map.length];
        for (int i = map.length - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            for (final char c : map[i]) {
                builder.append(c);
            }
            answer[(map.length - 1) - i] = builder.toString();
        }
        return answer;
    }
}
