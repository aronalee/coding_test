// prob: https://www.acmicpc.net/problem/11279

package backjoon.back11279;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(reader.readLine());
            if (value == 0) {
                writer.write(String.format("%d\n", queue.size() == 0 ? 0 : queue.remove()));
                continue;
            }
            queue.offer(value);
        }
        writer.flush();
    }
}
