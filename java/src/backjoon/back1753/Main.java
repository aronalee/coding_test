// prob: https://www.acmicpc.net/problem/1753

package backjoon.back1753;

import java.io.*;
import java.util.*;

class Edge {
    private final int nextId;
    private final int distance;

    public Edge(int nextId, int distance) {
        this.nextId = nextId;
        this.distance = distance;
    }

    public int id() {
        return nextId;
    }

    public int distance() {
        return distance;
    }
}

class Back1753 {
    private final List<List<Edge>> adjList;

    public Back1753(List<List<Edge>> adjList) {
        this.adjList = adjList;
    }

    public int[] getMinDistances(int startId) {
        int[] minDistances = new int[adjList.size()];
        Arrays.fill(minDistances, Integer.MAX_VALUE);
        minDistances[startId] = 0;
        boolean[] visited = new boolean[adjList.size()];
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::distance));
        queue.add(new Edge(startId, 0));
        while (!queue.isEmpty()) {
            Edge now = queue.remove();
            if (visited[now.id()])
                continue;
            visited[now.id()] = true;
            for (Edge next : adjList.get(now.id())) {
                int nextDistance = next.distance() + minDistances[now.id()];
                if (minDistances[next.id()] <= nextDistance)
                    continue;
                minDistances[next.id()] = nextDistance;
                queue.add(new Edge(next.id(), nextDistance));
            }
        }
        return minDistances;
    }
}


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int v = Integer.parseInt(tmp[0]);
        int e = Integer.parseInt(tmp[1]);
        int startId = Integer.parseInt(reader.readLine());
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int distance = Integer.parseInt(tmp[2]);
            adjList.get(src).add(new Edge(dst, distance));
        }
        Back1753 back1753 = new Back1753(adjList);
        int[] results = back1753.getMinDistances(startId);
        for (int i = 1; i <= v; i++) {
            writer.write((results[i] != Integer.MAX_VALUE ? results[i] : "INF") + "\n");
        }
        writer.flush();
    }
}
