// prob: https://www.acmicpc.net/problem/1414

package backjoon.back1414;

import java.io.*;
import java.util.*;

class Edge {
    private final int src;
    private final int dst;
    private final int distance;

    public Edge(int src, int dst, int distance) {
        this.src = src;
        this.dst = dst;
        this.distance = distance;
    }

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }

    public int getDistance() {
        return distance;
    }
}

class NotHaveMSTException extends Exception {
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] parents;

    private static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            parents[node2] = node1;
        }
    }

    private static int find(int node) {
        if (parents[node] == node)
            return node;
        return parents[node] = find(parents[node]);
    }

    private static List<Edge> createMST(List<Edge> list, int countNode) throws NotHaveMSTException {
        parents = new int[countNode];
        Arrays.setAll(parents, v -> v);
        List<Edge> mst = new LinkedList<>();
        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
        queue.addAll(list);
        int countEdge = 0;
        while (countEdge < countNode - 1 && !queue.isEmpty()) {
            Edge now = queue.remove();
            if (find(now.getSrc()) == find(now.getDst())) {
                continue;
            }
            union(now.getSrc(), now.getDst());
            mst.add(now);
            countEdge++;
        }
        int parent = find(0);
        for (int i = 0; i < parents.length; i++) {
            if (parent != find(i)) {
                throw new NotHaveMSTException();
            }
        }
        return mst;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Edge> edgeList = new ArrayList<>();
        for (int src = 0; src < n; src++) {
            String[] tmp = reader.readLine().split("");
            for (int dst = 0; dst < tmp.length; dst++) {
                int distance = 0;
                if (tmp[dst].equals("0")) {
                    continue;
                }
                int ascii = tmp[dst].charAt(0);
                if (ascii < 91)
                    distance = ascii - 64 + 26;
                else if (ascii < 123)
                    distance = ascii - 96;
                edgeList.add(new Edge(src, dst, distance));
            }
        }
        int sum = 0;
        try {
            List<Edge> mst = createMST(edgeList, n);
            for (Edge edge : edgeList) {
                sum += edge.getDistance();
            }
            for (Edge edge : mst) {
                sum -= edge.getDistance();
            }
        } catch (NotHaveMSTException e) {
            sum = -1;
        }
        writer.write(sum + "\n");
        writer.flush();
    }
}
