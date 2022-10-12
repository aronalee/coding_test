// prob: https://www.acmicpc.net/problem/1516

package backjoon.back1948;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    private final int id;
    private final int distance;

    public Node(int id, int distance) {
        this.id = id;
        this.distance = distance;
    }

    public int id() {
        return id;
    }

    public int distance() {
        return distance;
    }
}

class Back1948 {
    private final List<List<Node>> adjList;
    private final List<List<Node>> reverseAdjList;
    private final int[] maxDistances;
    private final int[] inDegrees;

    public Back1948(List<List<Node>> adjList, List<List<Node>> reverseAdjList, int[] maxDistances, int[] inDegrees) {
        this.adjList = adjList;
        this.reverseAdjList = reverseAdjList;
        this.maxDistances = maxDistances;
        this.inDegrees = inDegrees;
    }

    public int getMaxDistances(int startId, int endId) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startId, 0));
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (Node next : adjList.get(now.id())) {
                maxDistances[next.id()] = Math.max(maxDistances[next.id()], maxDistances[now.id()] + next.distance());
                inDegrees[next.id()]--;
                if (inDegrees[next.id()] != 0) {
                    continue;
                }
                queue.add(next);
            }
        }
        return maxDistances[endId];
    }

    public int countRoots(int endid) {
        int count = 0;
        boolean[] visited = new boolean[reverseAdjList.size()];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(endid, maxDistances[endid]));

        while (!queue.isEmpty()) {
            Node now = queue.remove();
            if (visited[now.id()])
                continue;
            visited[now.id()] = true;
            for (Node next : reverseAdjList.get(now.id())) {
                if (!(maxDistances[now.id()] == next.distance() + maxDistances[next.id()]) || visited[next.id()]) {
                    continue;
                }
                count++;
                queue.add(next);
            }
        }
        return count;
    }
}


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int[] inDegrees = new int[n + 1];
        List<List<Node>> adjList = new ArrayList<>();
        List<List<Node>> reverseAdjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            reverseAdjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] tmp = reader.readLine().split(" ");
            int src = Integer.parseInt(tmp[0]);
            int dst = Integer.parseInt(tmp[1]);
            int distance = Integer.parseInt(tmp[2]);
            adjList.get(src).add(new Node(dst, distance));
            reverseAdjList.get(dst).add(new Node(src, distance));
            inDegrees[dst]++;
        }
        String[] tmp = reader.readLine().split(" ");
        int startId = Integer.parseInt(tmp[0]);
        int endId = Integer.parseInt(tmp[1]);
        Back1948 back1948 = new Back1948(adjList, reverseAdjList, new int[n + 1], inDegrees);
        writer.write(back1948.getMaxDistances(startId, endId) + "\n");
        writer.write(back1948.countRoots(endId) + "\n");
        writer.flush();
    }
}
