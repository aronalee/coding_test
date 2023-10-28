// prob: https://www.acmicpc.net/problem/1939

package backjoon.back1939;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            splitLine = reader.readLine().split(" ");
            int nodeId1 = Integer.parseInt(splitLine[0]) - 1;
            int nodeId2 = Integer.parseInt(splitLine[1]) - 1;
            int cost = Integer.parseInt(splitLine[2]);
            adjList.get(nodeId1).add(Node.of(nodeId2, cost));
            adjList.get(nodeId2).add(Node.of(nodeId1, cost));
            minWeight = Math.min(minWeight, cost);
            maxWeight = Math.max(maxWeight, cost);
        }
        splitLine = reader.readLine().split(" ");
        int start = Integer.parseInt(splitLine[0]) - 1;
        int end = Integer.parseInt(splitLine[1]) - 1;
        Back1939 back1939 = new Back1939(adjList, n);
        int result = back1939.getMaxCost(List.of(start, end), minWeight, maxWeight);
        writer.write(result + "\n");
        writer.flush();
    }
}
