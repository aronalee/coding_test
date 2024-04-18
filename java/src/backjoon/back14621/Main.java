// prob: https://www.acmicpc.net/problem/14621

package backjoon.back14621;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int edgeTotal = Integer.parseInt(input[1]);
        List<Character> nodes = Arrays.stream(reader.readLine().split(" ")).map(s -> s.charAt(0))
                .collect(Collectors.toUnmodifiableList());
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < edgeTotal; i++) {
            String[] edge = reader.readLine().split(" ");
            int node1 = Integer.parseInt(edge[0]) - 1;
            int node2 = Integer.parseInt(edge[1]) - 1;
            int distance = Integer.parseInt(edge[2]);
            edges.add(new Edge(node1, node2, distance));
        }
        Back14621 back14621 = new Back14621();
        try {
            int distance = back14621.computeSumOfMinDistance(nodes, edges);
            writer.write(distance + "\n");
        } catch (IllegalStateException e) {
            writer.write("-1\n");
        }
        writer.flush();
    }
}
