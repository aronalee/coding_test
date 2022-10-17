// prob: https://www.acmicpc.net/problem/11725

package backjoon.back11725;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] findParents(List<List<Integer>> adjList, boolean[] visited) {
        int[] parentNode = new int[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (Integer child : adjList.get(node)) {
                if (visited[child]) {
                    parentNode[node] = child;
                    continue;
                }
                visited[child] = true;
                queue.add(child);
            }
        }
        return parentNode;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
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
        int[] parents = findParents(adjList, new boolean[n + 1]);
        for (int parent : parents) {
            if (parent == 0)
                continue;
            writer.write(parent + "\n");
        }
        writer.flush();
    }
}
