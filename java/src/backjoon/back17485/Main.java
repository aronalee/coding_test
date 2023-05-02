// prob: https://www.acmicpc.net/problem/17485

package backjoon.back17485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final int[] dx = new int[]{-1, 0, 1};
    private static final int EMPTY = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            splitLine = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        // dp[r][y][x]: 직전의 방향 선택이 r일 때 map[y][x]까지 도달하기 위한 최소 비용
        int[][][] dp = createDp(n, m, map);
        int answer = Integer.MAX_VALUE;
        for (int r = 0; r < dp.length; r++) {
            for (int x = 0; x < m; x++) {
                answer = Math.min(answer, getMinCost(map, dp, r, n - 1, x, m, n));
            }
        }
        writer.write(answer + "\n");
        writer.flush();
    }

    private static int[][][] createDp(int n, int m, int[][] map) {
        int[][][] dp = new int[3][n][m];
        for (int[][] subDp : dp) {
            for (int y = 0; y < n; y++) {
                Arrays.fill(subDp[y], EMPTY);
            }
        }
        for (int[][] subDp : dp) {
            System.arraycopy(map[0], 0, subDp[0], 0, subDp[0].length);
        }
        return dp;
    }

    private static int getMinCost(int[][] map, int[][][] dp, int r, int y, int x, int m, int n) {
        // 비어있지 않고 최솟값이 존재하면 이를 재사용한다.
        if (dp[r][y][x] != EMPTY) {
            return dp[r][y][x];
        }
        // 비어있으면 직전 방향을 제외하고 나머지 방향으로 이동했을 때의 최솟값을 구한다.
        for (int nextR = 0; nextR < dp.length; nextR++) {
            if (r == nextR) {
                continue;
            }
            int nextY = y - 1;
            int nextX = x + dx[nextR];
            if (nextY >= n || nextX >= m || nextX < 0) {
                continue;
            }
            dp[r][y][x] = Math.min(dp[r][y][x], getMinCost(map, dp, nextR, nextY, nextX, m, n));
        }
        // min(dp[r][y-1][abs((x-1)%2)], dp[r][y-1][abs((x+1)%2)]) + map[y][x]
        return dp[r][y][x] += map[y][x];
    }
}
