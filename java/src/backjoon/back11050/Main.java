// prob: https://www.acmicpc.net/problem/11050

package backjoon.back11050;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long factorial(int n) {
        if (n == 0) {
            return 1;
        }
        int acc = 1;
        for (int i = n; i > 0; i--) {
            acc *= i;
        }
        return acc;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);

        long result = factorial(n) / (factorial(n - k) * factorial(k));
        writer.write(result + "");
        writer.flush();
    }
}
