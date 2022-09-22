// prob: https://www.acmicpc.net/problem/10986

package backjoon.back10986;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        long[] sums = new long[n + 1];
        long[] counts = new long[m];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i < sums.length; i++) {
            sums[i] = (sums[i - 1] + Integer.parseInt(tokenizer.nextToken())) % m;
            counts[(int) (sums[i])]++;
        }
        long result = counts[0];
        for (long count : counts) {
            if (count < 1)
                continue;
            result += count * (count - 1) / 2;
        }
        writer.write(result + "\n");
        writer.flush();
    }
}
