// prob: https://www.acmicpc.net/problem/1927

package backjoon.back1927;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(reader.readLine());
            if (x == 0) {
                int minValue = 0;
                if (queue.size() != 0) {
                    minValue = queue.remove();
                }
                writer.write(minValue + "\n");
                continue;
            }
            queue.add(x);
        }
        writer.flush();
    }

}
