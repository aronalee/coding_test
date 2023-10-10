// prob: https://www.acmicpc.net/problem/17396

package backjoon.back17396;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        List<Boolean> isView = new ArrayList<>();
        for (String s : reader.readLine().split(" ")) {
            isView.add(s.equals("1"));
        }
        List<List<Node>> adjList = initAdjList(n, m, isView);
        Back17396 back17396 = new Back17396(adjList);
        long result = back17396.getMinCostNotViewedStatus(0, n - 1);
        if (result == Back17396.NOT_VISITED) {
            writer.write("-1\n");
            writer.flush();
            return;
        }
        writer.write(result + "\n");
        writer.flush();
    }

    private static List<List<Node>> initAdjList(int n, int m, List<Boolean> isView) throws IOException {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String line = reader.readLine();
            int src = Integer.parseInt(line.split(" ")[0]);
            int dst = Integer.parseInt(line.split(" ")[1]);
            int cost = Integer.parseInt(line.split(" ")[2]);
            adjList.get(src).add(Node.of(dst, cost, isView.get(dst)));
            adjList.get(dst).add(Node.of(src, cost, isView.get(src)));
        }
        return adjList;
    }
}

