// prob: https://www.acmicpc.net/problem/2251

package backjoon.back2251;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static List<Integer> searchCapacityCases(int[] capacities) {
        boolean[] remindC = new boolean[capacities[2] + 1];
        boolean[][][] visited = new boolean[capacities[0] + 1][capacities[1] + 1][capacities[2] + 1];
        Queue<Integer[]> queue = new LinkedList<>();
        visited[0][0][capacities[2]] = true;
        queue.add(new Integer[]{0, 0, capacities[2]});
        while (!queue.isEmpty()) {
            Integer[] buckets = queue.remove();
            for (int src = 0; src < 3; src++) {
                for (int i = 1; i <= 2; i++) {
                    Integer[] newBuckets = buckets.clone();
                    int dst = (src + i) % 3;
                    newBuckets[dst] += newBuckets[src];
                    newBuckets[src] = 0;
                    if (newBuckets[dst] > capacities[dst]) {
                        newBuckets[src] = newBuckets[dst] - capacities[dst];
                        newBuckets[dst] = capacities[dst];
                    }
                    if (newBuckets[0] == 0) {
                        remindC[newBuckets[2]] = true;
                    }
                    if (visited[newBuckets[0]][newBuckets[1]][newBuckets[2]])
                        continue;
                    visited[newBuckets[0]][newBuckets[1]][newBuckets[2]] = true;
                    queue.add(newBuckets);
                }
            }
        }
        List<Integer> log = new ArrayList<>();
        for (int i = 0; i < remindC.length; i++) {
            if (remindC[i])
                log.add(i);
        }
        return log;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int[] buckets = new int[3];
        for (int i = 0; i < tmp.length; i++) {
            buckets[i] = Integer.parseInt(tmp[i]);
        }
        List<Integer> bucketCases = searchCapacityCases(buckets);
        for (int bucketCase : bucketCases) {
            writer.write(bucketCase + " ");
        }
        writer.flush();
    }
}
