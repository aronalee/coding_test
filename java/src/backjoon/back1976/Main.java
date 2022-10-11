package backjoon.back1976;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 단순탐색
public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void bfs(boolean[] visited, List<List<Integer>> adjList, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (Integer next : adjList.get(node)) {
                if (visited[next])
                    continue;
                visited[next] = true;
                queue.add(next);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tmp = reader.readLine().split(" ");
            List<Integer> list = new ArrayList<>();
            for (int city = 0; city < tmp.length; city++) {
                if (tmp[city].equals("1"))
                    list.add(city);
            }
            adjList.add(list);
        }
        boolean[] visited = new boolean[n];
        String[] tmp = reader.readLine().split(" ");
        int[] plans = new int[m];
        for (int i = 0; i < tmp.length; i++) {
            plans[i] = Integer.parseInt(tmp[i]) - 1;
        }
        bfs(visited, adjList, plans[0]);
        boolean visitedAll = true;
        for (int plan : plans) {
            if (!visited[plan]) {
                visitedAll = false;
                break;
            }
        }
        writer.write(visitedAll ? "YES" : "NO");
        writer.flush();
    }
}
