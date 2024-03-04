// prob: https://www.acmicpc.net/problem/20182

package backjoon.back20182;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int srcNode = Integer.parseInt(input[2]);
        int dstNode = Integer.parseInt(input[3]);
        int budget = Integer.parseInt(input[4]);
        List<List<Node>> adjList = readAdjList(n, m);
        Back20182 back20182 = new Back20182();
        try {
            int minCost = back20182.findMinShyCost(adjList, srcNode, dstNode, budget);
            writer.write(minCost + "\n");
        } catch (NoSuchElementException e) {
            writer.write("-1\n");
        }
        writer.flush();
    }

    private static List<List<Node>> readAdjList(int n, int m) throws IOException {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            int w = Integer.parseInt(edge[2]);
            adjList.get(u).add(new Node(v, w));
            adjList.get(v).add(new Node(u, w));
        }
        return adjList;
    }

}
