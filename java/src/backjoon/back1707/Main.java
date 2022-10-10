// prob: https://www.acmicpc.net/problem/1707

package backjoon.back1707;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean checkBipartite(List<List<Integer>> adjList, int size) {
        int[] bipartite = new int[size + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            if (bipartite[i] != 0)
                continue;
            queue.add(i);
            bipartite[i] = 1;
            while (!queue.isEmpty()) {
                int node = queue.remove();
                for (Integer next : adjList.get(node)) {
                    if (bipartite[next] != 0) {
                        if (bipartite[next] == bipartite[node])
                            return false;
                        continue;
                    }
                    bipartite[next] = -bipartite[node];
                    queue.add(next);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(reader.readLine());
        for (int i = 0; i < k; i++) {
            String[] tmp = reader.readLine().split(" ");
            int nodes = Integer.parseInt(tmp[0]);
            int edges = Integer.parseInt(tmp[1]);
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i1 = 0; i1 <= nodes; i1++) {
                adjList.add(new ArrayList<>());
            }
            for (int i1 = 0; i1 < edges; i1++) {
                tmp = reader.readLine().split(" ");
                int src = Integer.parseInt(tmp[0]);
                int dst = Integer.parseInt(tmp[1]);
                adjList.get(src).add(dst);
                adjList.get(dst).add(src);
            }
            writer.write((checkBipartite(adjList, nodes) ? "YES" : "NO") + "\n");
        }
        writer.flush();
    }
}
