// prob: https://www.acmicpc.net/problem/1715

package backjoon.back1715;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(reader.readLine()));
        }
        int acc = 0;
        while (queue.size() > 1) {
            int value1 = queue.remove();
            int value2 = queue.remove();
            acc += value1 + value2;
            queue.add(value1 + value2);
        }
        writer.write(acc + "\n");
        writer.flush();
    }
}
