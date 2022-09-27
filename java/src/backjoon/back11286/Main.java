// prob: https://www.acmicpc.net/problem/11286

package backjoon.back11286;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class NumberComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (Math.abs(o1) == Math.abs(o2)) {
            if (o1.intValue() == o2.intValue())
                return 0;
            return o1 < o2 ? -1 : 1;
        }
        return Math.abs(o1) < Math.abs(o2) ? -1 : 1;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Queue<Integer> queue = new PriorityQueue<>(new NumberComparator());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(reader.readLine());
        }
        for (int value : values) {
            if (value == 0)
                if (!queue.isEmpty())
                    writer.write(queue.poll() + "\n");
                else
                    writer.write("0\n");
            else
                queue.add(value);
        }
        writer.flush();
    }
}
