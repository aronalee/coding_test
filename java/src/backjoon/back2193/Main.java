// prob: https://www.acmicpc.net/problem/2193

package backjoon.back2193;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        long[] m = new long[n + 1];
        m[1] = 1;
        for (int i = 2; i < m.length; i++) {
            m[i] = m[i - 1] + m[i - 2];
        }
        writer.write(m[n] + "\n");
        writer.flush();
    }
}
