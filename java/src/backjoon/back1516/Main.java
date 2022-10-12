// prob: https://www.acmicpc.net/problem/1516

package backjoon.back1516;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Back1516 {
    private final List<List<Integer>> adjList;
    private final int[] times;
    private final int[] inDegrees;

    public Back1516(List<List<Integer>> adjList, int[] times, int[] inDegrees) {
        this.adjList = adjList;
        this.times = times;
        this.inDegrees = inDegrees;
    }


    private void topologySort(int[] totalTimes) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer next : adjList.get(now)) {
                inDegrees[next]--;
                totalTimes[next] = Math.max(totalTimes[next], times[now] + totalTimes[now]);
                if (inDegrees[next] != 0)
                    continue;
                queue.add(next);
            }
        }
    }

    public int[] getBuildingTimes() {
        int[] totalTimes = new int[adjList.size()];
        topologySort(totalTimes);
        for (int i = 0; i < times.length; i++) {
            totalTimes[i] += times[i];
        }
        return totalTimes;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] times = new int[n + 1];
        int[] inDegrees = new int[n + 1];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int src = 1; src < times.length; src++) {
            String[] tmp = reader.readLine().split(" ");
            times[src] = Integer.parseInt(tmp[0]);
            int idx = 1;
            while (!tmp[idx].equals("-1")) {
                int dst = Integer.parseInt(tmp[idx]);
                inDegrees[src]++;
                adjList.get(dst).add(src);
                idx++;
            }
        }
        Back1516 back1516 = new Back1516(adjList, times, inDegrees);
        int[] results = back1516.getBuildingTimes();
        for (int i = 1; i < results.length; i++) {
            writer.write(results[i] + "\n");
        }
        writer.flush();
    }
}
