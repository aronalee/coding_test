// prob: https://www.acmicpc.net/problem/13549

package backjoon.back13549;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int k = Integer.parseInt(tmp[1]);
        int result = createMinSecond(n, k);
        writer.write(result + "\n");
        writer.flush();
    }

    private static int createMinSecond(final int n, final int k) {
        if (n >= k) {
            return n - k;
        }
        int[] m = new int[(k + 1) * 2];
        Arrays.fill(m, Integer.MAX_VALUE);
        m[n] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int now = queue.remove();
            if (now - 1 >= 0 && m[now] + 1 < m[now - 1]) {
                m[now - 1] = m[now] + 1;
                queue.add(now - 1);
            }
            if (now + 1 < m.length && m[now] + 1 < m[now + 1]) {
                m[now + 1] = m[now] + 1;
                queue.add(now + 1);
            }
            if (now * 2 < m.length && m[now] < m[now * 2]) {
                m[now * 2] = m[now];
                queue.add(now * 2);
            }
        }
        return m[k];
    }
}
