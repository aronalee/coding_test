// prob: https://www.acmicpc.net/problem/15900

package backjoon.back15900;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int nodeTotal = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeTotal; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodeTotal - 1; i++) {
            String[] input = reader.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        Back15900 back15900 = new Back15900(adjList);
        if (back15900.hasWinCase()) {
            writer.write("Yes");
        } else {
            writer.write("No");
        }
        writer.flush();
    }

}
