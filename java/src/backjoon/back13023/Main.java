// prob: https://www.acmicpc.net/problem/13023

package backjoon.back13023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<List<Integer>> adjList = new ArrayList<>();

    private static int countRelationUntil5(int node, boolean[] visited, int count) {
        if (visited[node] || count >= 5)
            return count;
        visited[node] = true;
        int maxCount = 0;
        for (int child : adjList.get(node)) {
            maxCount = Math.max(countRelationUntil5(child, visited, count), maxCount);
            if (maxCount >= 4) {
                break;
            }
        }
        visited[node] = false;
        return count + maxCount + 1;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int edges = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < edges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        int answer = 0;
        for (int initNode = 0; initNode < n; initNode++) {
            if (countRelationUntil5(initNode, new boolean[n], 0) >= 5) {
                answer = 1;
                break;
            }
        }
        writer.write(answer + "");
        writer.flush();
    }
}
