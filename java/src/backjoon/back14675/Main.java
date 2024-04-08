// prob: https://www.acmicpc.net/problem/14675

package backjoon.back14675;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int nodeTotal = Integer.parseInt(reader.readLine());
        List<List<Integer>> adjList = readAdjList(nodeTotal);
        Back14675 back14675 = new Back14675(adjList, nodeTotal);
        int testCaseTotal = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCaseTotal; i++) {
            TestCase tc = readTestCase();
            switch (tc.type) {
                case CUT_VERTEX:
                    writer.write(back14675.isCutVertex(tc.value) ? "yes" : "no");
                    break;
                case BRIDGE:
                    writer.write(back14675.isBridge(tc.value) ? "yes" : "no");
                    break;
            }
            writer.write("\n");
        }
        writer.flush();
    }

    private static List<List<Integer>> readAdjList(int nodeTotal) throws IOException {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= nodeTotal; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int id = 1; id < nodeTotal; id++) {
            String[] input = reader.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        return adjList;
    }

    private static TestCase readTestCase() throws IOException {
        String[] input = reader.readLine().split(" ");
        int typeInput = Integer.parseInt(input[0]);
        int valueInput = Integer.parseInt(input[1]);
        switch (typeInput) {
            case 1:
                return new TestCase(NodeType.CUT_VERTEX, valueInput);
            case 2:
                return new TestCase(NodeType.BRIDGE, valueInput);
            default:
                throw new IllegalArgumentException("Invalid type input");
        }
    }

    private enum NodeType {
        CUT_VERTEX, BRIDGE
    }

    private static class TestCase {
        NodeType type;
        int value;

        public TestCase(NodeType type, int value) {
            this.type = type;
            this.value = value;
        }
    }
}
