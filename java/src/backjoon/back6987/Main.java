// prob: https://www.acmicpc.net/problem/6987

package backjoon.back6987;

import java.io.*;
import java.util.Arrays;

public class Main {
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[][][] testCases = new int[4][][];
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < 4; i++) {
                testCases[i] = readTestCase(reader);
            }
        }
        Back6987 back6987 = new Back6987();
        for (int[][] testCase : testCases) {
            writer.write(back6987.isPossible(testCase) ? "1 " : "0 ");
        }
        writer.flush();
    }

    private static int[][] readTestCase(BufferedReader reader) throws IOException {
        int[] line = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[][] gameResult = new int[6][3];
        for (int i = 0; i < 6; i++) {
            System.arraycopy(line, i * 3 + 0, gameResult[i], 0, 3);
        }
        return gameResult;
    }
}
