// prob: https://www.acmicpc.net/problem/17484

package backjoon.back17484;

import java.util.Arrays;

public class Back17484 {

    private static final int EMPTY = -1;
    private static final int VISITED_MOON = 0;
    private static final int[] DIRECTIONS = new int[]{-1, 0, 1};

    public int computeMinCost(int[][] map, int heightMax, int widthMax) {
        int[][][] memoization = createMemoization(heightMax, widthMax);
        for (int widthStart = 0; widthStart < widthMax; widthStart++) {
            for (int directionIdx = 0; directionIdx < DIRECTIONS.length; directionIdx++) {
                dp(map, memoization, 0, widthStart, directionIdx);
            }
        }
        return Arrays.stream(memoization[0])
            .flatMapToInt(Arrays::stream)
            .filter(value -> value != EMPTY)
            .min().orElse(EMPTY);
    }

    private int dp(int[][] map, int[][][] memoization, int height, int width, int beforeDirection) {
        if (height>=map.length) {
            return VISITED_MOON;
        }
        if (memoization[height][width][beforeDirection] != EMPTY) {
            return memoization[height][width][beforeDirection];
        }
        int costMin=Integer.MAX_VALUE;
        for (int directionIdx = 0; directionIdx < DIRECTIONS.length; directionIdx++) {
            if (beforeDirection == directionIdx || width + DIRECTIONS[directionIdx] < 0 ||
                width + DIRECTIONS[directionIdx] >= map[width].length) {
                continue;
            }
            int result = dp(map, memoization, height + 1, width + DIRECTIONS[directionIdx],
                directionIdx);
            costMin = Math.min(costMin, result);
        }
        memoization[height][width][beforeDirection] = costMin+map[height][width];
        return memoization[height][width][beforeDirection];
    }

    private int[][][] createMemoization(int heightMax, int widthMax) {
        int[][][] memoization = new int[heightMax][widthMax][DIRECTIONS.length];
        for (int[][] ints : memoization) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, EMPTY);
            }
        }
        return memoization;
    }
}
