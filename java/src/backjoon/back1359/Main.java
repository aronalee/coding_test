// prob: https://www.acmicpc.net/problem/1359

package backjoon.back1359;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        Back1359 back1359 = new Back1359();
        double result = back1359.computeWinPercent(n, m, k);
        writer.write(String.format("%.16f", result));
        writer.flush();
    }
}
