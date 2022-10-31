// prob: https://www.acmicpc.net/problem/2342

package backjoon.back2342;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100_000 * 4;

    private static int foregroundStep(int step) {
        if (step == 0) {
            return 0;
        }
        int result = (step + 1) % 5;
        result = result != 0 ? result : 1;
        return result;
    }

    private static int backgroundStep(int step) {
        if (step == 0) {
            return 0;
        }
        int result = Math.abs((step - 1)) % 5;
        result = result != 0 ? result : 4;
        return result;
    }

    private static int reverseStep(int step) {
        if (step == 0) {
            return 0;
        }
        int result = (step + 2) % 4;
        result = result != 0 ? result : 4;
        return result;
    }

    private static int getMinCost(int[] steps, int n) {
        int[][][] m = new int[n + 1][5][5];
        for (int[][] ints : m) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, INF);
            }
        }
        m[0][0][0] = 0;
        for (int i = 1; i < steps.length + 1; i++) {
            int step = steps[i - 1];
            for (int left = 0; left < 5; left++) {
                m[i][left][step] = Math.min(m[i][left][step], m[i - 1][left][foregroundStep(step)] + 3);
                m[i][left][step] = Math.min(m[i][left][step], m[i - 1][left][backgroundStep(step)] + 3);
                m[i][left][step] = Math.min(m[i][left][step], m[i - 1][left][reverseStep(step)] + 4);
                m[i][left][step] = Math.min(m[i][left][step], m[i - 1][left][0] + 2);
                m[i][left][step] = Math.min(m[i][left][step], m[i - 1][left][step] + 1);
            }
            for (int right = 0; right < 5; right++) {
                m[i][step][right] = Math.min(m[i][step][right], m[i - 1][foregroundStep(step)][right] + 3);
                m[i][step][right] = Math.min(m[i][step][right], m[i - 1][backgroundStep(step)][right] + 3);
                m[i][step][right] = Math.min(m[i][step][right], m[i - 1][reverseStep(step)][right] + 4);
                m[i][step][right] = Math.min(m[i][step][right], m[i - 1][0][right] + 2);
                m[i][step][right] = Math.min(m[i][step][right], m[i - 1][step][right] + 1);
            }
        }
        int minCost = INF;
        for (int left = 0; left < 5; left++) {
            for (int right = 0; right < 5; right++) {
                minCost = Math.min(minCost, m[n][left][right]);
            }
        }
        return minCost;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int[] steps = new int[tmp.length - 1];
        for (int i = 0; i < tmp.length - 1; i++) {
            steps[i] = Integer.parseInt(tmp[i]);
        }
        int result = getMinCost(steps, steps.length);
        writer.write(result + "\n");
        writer.flush();
    }
}
