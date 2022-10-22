// prob: https://www.acmicpc.net/problem/11437

package backjoon.back11437;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final List<List<Integer>> adjList = new ArrayList<>();
    private static int[] depths;
    private static int[] parents;

    private static void initDepthsAndParents(int n) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        depths[1] = 1;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer next : adjList.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                depths[next] = depths[now] + 1;
                parents[next] = now;
                queue.add(next);
            }
        }
    }


    private static int getLCA(int node1, int node2) {
        int diffDepth = Math.abs(depths[node1] - depths[node2]);
        if (depths[node1] > depths[node2]) {
            for (int i = 0; i < diffDepth; i++) {
                node1 = parents[node1];
            }
        } else if (depths[node1] < depths[node2]) {
            for (int i = 0; i < diffDepth; i++) {
                node2 = parents[node2];
            }
        }
        int ancestor1 = node1;
        int ancestor2 = node2;
        while (ancestor1 != ancestor2) {
            ancestor1 = parents[ancestor1];
            ancestor2 = parents[ancestor2];
        }
        return ancestor1;
    }

    public static void main(String[] args) throws IOException {
        int n;
        List<int[]> inputs = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine());
            for (int i = 0; i <= n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int i = 0; i < n - 1; i++) {
                String[] tmp = reader.readLine().split(" ");
                int node1 = Integer.parseInt(tmp[0]);
                int node2 = Integer.parseInt(tmp[1]);
                adjList.get(node1).add(node2);
                adjList.get(node2).add(node1);
            }
            int m = Integer.parseInt(reader.readLine());
            for (int i = 0; i < m; i++) {
                String[] tmp = reader.readLine().split(" ");
                int node1 = Integer.parseInt(tmp[0]);
                int node2 = Integer.parseInt(tmp[1]);
                inputs.add(new int[]{node1, node2});
            }
        }
        depths = new int[n + 1];
        parents = new int[n + 1];
        initDepthsAndParents(n + 1);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            for (int[] input : inputs) {
                int lca = getLCA(input[0], input[1]);
                writer.write(lca + "\n");
            }
            writer.flush();
        }
    }
}
