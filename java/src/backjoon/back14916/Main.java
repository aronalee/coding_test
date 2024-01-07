// prob: https://www.acmicpc.net/problem/14916

package backjoon.back14916;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Back14916 back14916 = new Back14916();
        int result = back14916.countMinCoin(n);
        if (result == Back14916.EMPTY) {
            result = -1;
        }
        writer.write(String.valueOf(result));
        writer.flush();
    }
}
