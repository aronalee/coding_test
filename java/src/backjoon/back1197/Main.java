// prob: https://www.acmicpc.net/problem/1197

package backjoon.back1197;

import java.io.*;
import java.util.*;

class Edge {
    private final int now;
    private final int next;
    private final int weight;

    public Edge(int now, int next, int weight) {
        this.now = now;
        this.next = next;
        this.weight = weight;
    }

    public int getNow() {
        return now;
    }

    public int getNext() {
        return next;
    }

    public int getWeight() {
        return weight;
    }
}

class Back1197 {
    private final Queue<Edge> queue;
    private final int countNode;

    public Back1197(Queue<Edge> queue, int countNode) {
        this.queue = queue;
        this.countNode = countNode;
    }

    private void union(int[] parents, int node1, int node2) {
        node1 = find(parents, node1);
        node2 = find(parents, node2);
        if (node1 != node2) {
            parents[node2] = parents[node1];
        }
    }

    private int find(int[] parents, int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = find(parents, parents[node]);
    }

    public List<Edge> makeMST() {
        int[] parents = new int[countNode + 1];
        Arrays.setAll(parents, v -> v);
        List<Edge> mst = new LinkedList<>();
        int count = 0;
        while (count < countNode - 1) {
            Edge edge = queue.remove();
            if (find(parents, edge.getNow()) == find(parents, edge.getNext()))
                continue;
            union(parents, edge.getNow(), edge.getNext());
            mst.add(edge);
            count++;
        }
        return mst;
    }

}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int v = Integer.parseInt(tmp[0]);
        int e = Integer.parseInt(tmp[1]);
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        for (int i = 0; i < e; i++) {
            tmp = reader.readLine().split(" ");
            int node1 = Integer.parseInt(tmp[0]);
            int node2 = Integer.parseInt(tmp[1]);
            int weight = Integer.parseInt(tmp[2]);
            queue.add(new Edge(node1, node2, weight));
        }
        Back1197 back1197 = new Back1197(queue, v);
        List<Edge> mst = back1197.makeMST();
        int result = 0;
        for (Edge edge : mst) {
            result += edge.getWeight();
        }
        writer.write(result + "\n");
        writer.flush();
    }
}
