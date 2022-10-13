// prob: https://www.acmicpc.net/problem/1916

package backjoon.back1916;

import java.io.*;
import java.util.*;

class Edge {
    private final int id;
    private final int cost;

    public Edge(int id, int cost) {
        this.id = id;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }
}

class Back1916 {
    private final List<List<Edge>> adjList;

    public Back1916(List<List<Edge>> adjList) {
        this.adjList = adjList;
    }

    public int getMinCost(int startId, int endId) {
        boolean[] visited = new boolean[adjList.size()];
        int[] distances = new int[adjList.size()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getCost));
        queue.add(new Edge(startId, 0));
        distances[startId] = 0;
        while (!queue.isEmpty()) {
            Edge now = queue.remove();
            if (visited[now.getId()]) {
                continue;
            }
            visited[now.getId()] = true;
            for (Edge next : adjList.get(now.getId())) {
                int cost = next.getCost() + distances[now.getId()];
                if (distances[next.getId()] <= cost) {
                    continue;
                }
                distances[next.getId()] = cost;
                queue.add(new Edge(next.getId(), cost));
            }
        }
        return distances[endId];
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        String[] tmp;
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            adjList.get(src).add(new Edge(dst, cost));
        }
        tmp = reader.readLine().split(" ");
        int src = Integer.parseInt(tmp[0]);
        int dst = Integer.parseInt(tmp[1]);
        Back1916 back1916 = new Back1916(adjList);
        writer.write(back1916.getMinCost(src, dst) + "\n");
        writer.flush();
    }
}
