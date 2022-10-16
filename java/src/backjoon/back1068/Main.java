// prob: https://www.acmicpc.net/problem/1068

package backjoon.back1068;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<List<Integer>> adjList = new ArrayList<>();

    private static int countLeaf(int root, int removeNode, boolean[] visited) {
        int count = 0;
        visited[root] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (node == removeNode)
                continue;
            int countNotVisited = 0;
            for (Integer child : adjList.get(node)) {
                if (visited[child])
                    continue;
                if (child == removeNode)
                    continue;
                visited[child] = true;
                countNotVisited++;
                queue.add(child);
            }
            if (countNotVisited == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        String[] tmp = reader.readLine().split(" ");
        int rootNode = 0;
        for (int i = 0; i < tmp.length; i++) {
            int parent = Integer.parseInt(tmp[i]);
            if (parent == -1) {
                rootNode = i;
                continue;
            }
            adjList.get(parent).add(i);
            adjList.get(i).add(parent);
        }
        int removeNode = Integer.parseInt(reader.readLine());
        int result = countLeaf(rootNode, removeNode, new boolean[n]);
        writer.write(result + "\n");
        writer.flush();
    }
}
