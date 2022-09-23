// prob: https://www.acmicpc.net/problem/2018

package back2018;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int sum = 0;
        int start = 0;
        int end = 0;
        int count = 1;
        while (end < n) {
            if (sum <= n) {
                if (sum == n) count++;
                end++;
                sum += end;
                continue;
            }
            start++;
            sum -= start;
        }
        writer.write("" + count);
        writer.flush();
    }
}
