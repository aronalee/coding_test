// prob: https://www.acmicpc.net/problem/3584

package backjoon.back3584;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        List<TestCase> testCases = readTestCases();
        Back3584 back3584 = new Back3584();
        for (TestCase testCase : testCases) {
            int nearestCommonAncestor = back3584.findNearestCommonAnscestor(testCase.adjList, testCase.node1, testCase.node2);
            writer.write(nearestCommonAncestor + "\n");
        }
        writer.flush();
    }

    private static List<TestCase> readTestCases() throws IOException {
        int totalTestCases = Integer.parseInt(reader.readLine());
        List<TestCase> testCases = new ArrayList<>();
        for (int i = 0; i < totalTestCases; i++) {
            int totalNodes = Integer.parseInt(reader.readLine());
            List<List<Integer>> adjList = new ArrayList<>();
            for (int j = 0; j <= totalNodes; j++) {
                adjList.add(new ArrayList<>());
            }
            for (int j = 0; j < totalNodes - 1; j++) {
                String[] edge = reader.readLine().split(" ");
                int parent = Integer.parseInt(edge[0]);
                int child = Integer.parseInt(edge[1]);
                adjList.get(child).add(parent);
            }
            String[] nodes = reader.readLine().split(" ");
            testCases.add(new TestCase(adjList, Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1])));
        }
        return testCases;
    }

    private static class TestCase {
        private final List<List<Integer>> adjList;
        private final int node1;
        private final int node2;

        private TestCase(List<List<Integer>> adjList, int node1, int node2) {
            this.adjList = adjList;
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}
