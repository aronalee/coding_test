// prob: https://www.acmicpc.net/problem/10971

package backjoon.back10971;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int inputNodes = Integer.parseInt(reader.readLine());
        int[][] adjMetric = new int[inputNodes][inputNodes];
        for (int y = 0; y < adjMetric.length; y++) {
            String[] inputWeights = reader.readLine().split(" ");
            for (int x = 0; x < adjMetric[y].length; x++) {
                adjMetric[y][x] = Integer.parseInt(inputWeights[x]);
            }
        }
        Back10971 back10971 = new Back10971();
        int result = back10971.findMinCostTSP(inputNodes, adjMetric);
        writer.write(result + "\n");
        writer.flush();
    }
}
