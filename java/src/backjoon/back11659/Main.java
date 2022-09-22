// prob: https://www.acmicpc.net/problem/11659

package backjoon.back11659;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputSize = reader.readLine().split(" ");
        int n = Integer.parseInt(inputSize[0]);
        int m = Integer.parseInt(inputSize[1]);
        int[] sumRange = new int[n + 1];
        String[] numberInput = reader.readLine().split(" ");
        for (int i = 1; i < sumRange.length; i++) {
            sumRange[i] = sumRange[i - 1] + Integer.parseInt(numberInput[i - 1]);
        }
        for (int i = 0; i < m; i++) {
            String[] inputs = reader.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int end = Integer.parseInt(inputs[1]);
            writer.write(sumRange[end] - sumRange[start - 1] + "\n");
        }
        writer.flush();
    }
}
