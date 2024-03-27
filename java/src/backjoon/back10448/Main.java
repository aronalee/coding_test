// prob: https://www.acmicpc.net/problem/10448

package backjoon.back10448;

import java.io.*;
import java.util.stream.IntStream;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] triangleNumbers = IntStream
            .range(1, 45)
            .map(i -> i * (i + 1) / 2)
            .toArray();

    public static void main(String[] args) throws IOException {
        int testCaseTotal = Integer.parseInt(reader.readLine());
        for (int testCase = 0; testCase < testCaseTotal; testCase++) {
            int target = Integer.parseInt(reader.readLine());
            writer.write((isEurekaNum(target) ? 1 : 0) + "\n");
        }
        writer.flush();
    }

    private static boolean isEurekaNum(int target) {
        return isEurekaNumber(target, 0, 0);
    }

    private static boolean isEurekaNumber(int target, int acc, int depth) {
        if (depth == 3) {
            return target == acc;
        }
        for (int triangleNumber : triangleNumbers) {
            if (isEurekaNumber(target, acc + triangleNumber, depth + 1)) {
                return true;
            }
        }
        return false;
    }

}
