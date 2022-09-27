// prob: https://www.acmicpc.net/problem/2164

package backjoon.back2164;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int count = 0;
        while (queue.size() > 1) {
            int card = queue.poll();
            if (count % 2 == 1)
                queue.add(card);
            count++;
        }
        writer.write("" + queue.poll());
        writer.flush();
    }
}
