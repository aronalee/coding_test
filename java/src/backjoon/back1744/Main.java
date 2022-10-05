// prob: https://www.acmicpc.net/problem/1744

package backjoon.back1744;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Queue<Integer> positiveNumbers = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> negativeNumbers = new PriorityQueue<>();
        Queue<Integer> sequence = new LinkedList<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(reader.readLine());
            if (value > 0)
                positiveNumbers.add(value);
            else
                negativeNumbers.add(value);
        }
        while (negativeNumbers.size() > 1) {
            int value1 = negativeNumbers.remove();
            int value2 = negativeNumbers.remove();
            sequence.add(value1 * value2);
        }
        if (negativeNumbers.size() == 1)
            sequence.add(negativeNumbers.remove());
        while (positiveNumbers.size() > 1) {
            int value1 = positiveNumbers.remove();
            int value2 = positiveNumbers.remove();
            if (value1 * value2 < value1 + value2) {
                sequence.add(value1);
                sequence.add(value2);
                continue;
            }
            sequence.add(value1 * value2);
        }
        if (positiveNumbers.size() == 1)
            sequence.add(positiveNumbers.remove());
        int acc = 0;
        while (!sequence.isEmpty())
            acc += sequence.remove();
        writer.write(acc + "\n");
        writer.flush();
    }
}
