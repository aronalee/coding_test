// prob: https://www.acmicpc.net/problem/1300

package backjoon.back1300;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(reader.readLine());
        long k = Long.parseLong(reader.readLine());
        long start = 1;
        long end = k;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long ctr = 0;
            for (int i = 1; i <= n; i++) {
                ctr += Math.min(mid / i, n);
            }
            if (ctr < k)
                start = mid + 1;
            else {
                answer = mid;
                end = mid - 1;
            }
        }
        writer.write(answer + "\n");
        writer.flush();
    }
}
