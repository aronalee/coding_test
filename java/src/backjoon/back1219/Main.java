// prob: https://www.acmicpc.net/problem/1219

package backjoon.back1219;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Edge {
    private final int src;
    private final int dst;
    private final int cost;

    public int getSrc() {
        return src;
    }

    public int getDst() {
        return dst;
    }

    public int getCost() {
        return cost;
    }

    public Edge(int src, int dst, int cost) {
        this.src = src;
        this.dst = dst;
        this.cost = cost;
    }
}

class NonConnectedGraphException extends Exception {
}

class PositiveCycleException extends Exception {
}


class Back1219 {
    private final Edge[] edges;
    private final int countNodes;
    private final long[] earnCosts;
    private final List<List<Integer>> adjList;

    public Back1219(Edge[] edges, int countNodes, long[] earnCosts, List<List<Integer>> adjList) {
        this.edges = edges;
        this.countNodes = countNodes;
        this.earnCosts = earnCosts;
        this.adjList = adjList;
    }

    private void bellman_ford(long[] costs) {
        for (int i = 0; i < 100; i++) {
            for (Edge edge : edges) {
                if (costs[edge.getSrc()] == Long.MIN_VALUE) {
                    continue;
                }
                if (costs[edge.getSrc()] == Long.MAX_VALUE) {
                    costs[edge.getDst()] = Long.MAX_VALUE;
                }
                if (costs[edge.getDst()]==Long.MAX_VALUE) {
                    continue;
                }
                long subCost = this.earnCosts[edge.getDst()] + costs[edge.getSrc()] - edge.getCost();
                if (costs[edge.getDst()] >= subCost) {
                    continue;
                }
                costs[edge.getDst()] = (i < countNodes) ? subCost : Long.MAX_VALUE;
            }
        }
    }


    public long getCosts(int src, int dst) throws NonConnectedGraphException, PositiveCycleException {
        long[] costs = new long[this.countNodes];
        Arrays.fill(costs, Long.MIN_VALUE);
        costs[src] = earnCosts[src];
        bellman_ford(costs);
        if (costs[dst] == Long.MIN_VALUE) {
            throw new NonConnectedGraphException();
        } else if (costs[dst] == Long.MAX_VALUE) {
            throw new PositiveCycleException();
        }
        return costs[dst];
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int src = Integer.parseInt(tmp[1]);
        int dst = Integer.parseInt(tmp[2]);
        int countEdges = Integer.parseInt(tmp[3]);
        Edge[] edges = new Edge[countEdges];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            tmp = reader.readLine().split(" ");
            int start = Integer.parseInt(tmp[0]);
            int end = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            edges[i] = new Edge(start, end, cost);
            adjList.get(src).add(dst);
        }
        tmp = reader.readLine().split(" ");
        long[] earnCosts = new long[n];
        for (int i = 0; i < earnCosts.length; i++) {
            earnCosts[i] = Long.parseLong(tmp[i]);
        }
        long result = 0;
        try {
            Back1219 back1219 = new Back1219(edges, n, earnCosts, adjList);
            result = back1219.getCosts(src, dst);
            writer.write(result + "\n");
        } catch (NonConnectedGraphException e) {
            writer.write("gg");
        } catch (PositiveCycleException e) {
            writer.write("Gee");
        }
        writer.flush();
    }
}
