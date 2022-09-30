// prob: https://www.acmicpc.net/problem/10989

package backjoon.back10989;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] bucket = new int[10_001];
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(reader.readLine());
            bucket[k]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                writer.write(i + "\n");
            }
        }
        writer.flush();
    }
}
