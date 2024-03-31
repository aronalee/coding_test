// prob: https://www.acmicpc.net/problem/21924

package backjoon.back21924;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        LinkedList<Edge> edges = new LinkedList<>();
        int cityTotal;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            cityTotal = Integer.parseInt(input[0]);
            int edgeTotal = Integer.parseInt(input[1]);
            for (int i = 0; i < edgeTotal; i++) {
                input = reader.readLine().split(" ");
                int city1 = Integer.parseInt(input[0]);
                int city2 = Integer.parseInt(input[1]);
                int cost = Integer.parseInt(input[2]);
                edges.add(new Edge(city1, city2, cost));
            }
        }
        edges.sort(Comparator.comparingLong(e -> e.cost));
        int[] parents = new int[cityTotal + 1];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }
        long totalCost = 0;
        long usedCost = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.remove();
            totalCost += edge.cost;
            if (find(parents, edge.city1) == find(parents, edge.city2)) {
                continue;
            }
            union(parents, edge.city1, edge.city2);
            usedCost += edge.cost;
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            if (!isAllConnected(parents)) {
                writer.write("-1\n");
            } else {
                writer.write((totalCost - usedCost) + "\n");
            }
            writer.flush();
        }
    }

    private static boolean isAllConnected(int[] parents) {
        for (int i = 1; i < parents.length - 1; i++) {
            if (find(parents, i) != find(parents, i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static int find(int[] parents, int cityId) {
        if (parents[cityId] == cityId) {
            return cityId;
        }
        parents[cityId] = find(parents, parents[cityId]);
        return parents[cityId];
    }

    private static void union(int[] parents, int city1, int city2) {
        int city1Parent;
        int city2Parent;
        while ((city1Parent = find(parents, city1)) != (city2Parent = find(parents, city2))) {
            parents[city1Parent] = city2Parent;
        }
    }


    private static class Edge {
        private final int city1;
        private final int city2;
        private final long cost;

        public Edge(int city1, int city2, long cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }

    }
}