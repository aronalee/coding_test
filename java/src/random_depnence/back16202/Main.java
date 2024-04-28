// prob: https://www.acmicpc.net/problem/16202

package random_depnence.back16202;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int nodeTotal = Integer.parseInt(input[0]);
        int edgeTotal = Integer.parseInt(input[1]);
        int turnTotal = Integer.parseInt(input[2]);
        List<Edge> edges = new LinkedList<>();
        for (int i = 0; i < edgeTotal; i++) {
            String[] edgeInput = reader.readLine().split(" ");
            int from = Integer.parseInt(edgeInput[0]) - 1;
            int to = Integer.parseInt(edgeInput[1]) - 1;
            int weight = i + 1;
            edges.add(new Edge(from, to, weight));
        }
        Back16202 back16202 = new Back16202(nodeTotal, edges, turnTotal);
        List<Integer> scores = back16202.computeAllTurn();
        for (Integer score : scores) {
            writer.write(score + " ");
        }
        writer.flush();
    }
}
