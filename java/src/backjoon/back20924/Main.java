// https://www.acmicpc.net/problem/20924

package backjoon.back20924;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int rootNodeId = Integer.parseInt(splitLine[1]);
        List<List<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            splitLine = reader.readLine().split(" ");
            int a = Integer.parseInt(splitLine[0]);
            int b = Integer.parseInt(splitLine[1]);
            int d = Integer.parseInt(splitLine[2]);
            Edge edgeStartedAtA = Edge.of(b, d);
            Edge edgeStartedAtB = Edge.of(a, d);
            adjList.get(a).add(edgeStartedAtA);
            adjList.get(b).add(edgeStartedAtB);
        }
        Back20924 back20924 = new Back20924(adjList);
        boolean[] visited = new boolean[n + 1];
        GigaNodeInfo gigaNodeInfo = back20924.findGigaNodeInfo(visited, rootNodeId);
        int lengthOfPole = gigaNodeInfo.getLength();
        int leafLength = back20924.findMaximumLeafLength(visited, gigaNodeInfo.getGigaNodeId());
        writer.write(lengthOfPole + " " + leafLength + "\n");
        writer.flush();
    }

}
