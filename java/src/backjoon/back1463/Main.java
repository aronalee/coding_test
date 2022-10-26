// prob: https://www.acmicpc.net/problem/1463

package backjoon.back1463;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] m = new int[n + 1];
        m[1] = 0;
        for (int i = 2; i < m.length; i++) {
            m[i] = m[i - 1];
            if (i % 2 == 0) {
                m[i] = Math.min(m[i], m[i / 2]);
            }
            if (i % 3 == 0) {
                m[i] = Math.min(m[i], m[i / 3]);
            }
            m[i]++;
        }
        writer.write(m[n] + "\n");
        writer.flush();
    }
}
