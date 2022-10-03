// prob: https://www.acmicpc.net/problem/1167

package backjoon.back1167;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Back1167 {

    private final int countNode;
    private final List<List<Integer[]>> adjList;

    public Back1167(int countNode, List<List<Integer[]>> adjList) {
        this.countNode = countNode;
        this.adjList = adjList;
    }

    private int[] getWeights(int startNode) {
        boolean[] visited = new boolean[countNode];
        int[] weights = new int[countNode];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;
        while (!queue.isEmpty()) {
            int node = queue.remove();
            for (Integer[] child : adjList.get(node)) {
                int childNode = child[0];
                int childWeight = child[1];
                if (visited[childNode])
                    continue;
                weights[childNode] = weights[node] + childWeight;
                visited[childNode] = true;
                queue.add(childNode);
            }
        }
        return weights;
    }

    private int getMaxWeightIdx(int[] weights) {
        int maxIdx = 0;
        for (int idx = 0; idx < weights.length; idx++)
            if (weights[maxIdx] < weights[idx])
                maxIdx = idx;
        return maxIdx;
    }

    public int getDiameter() {
        int[] weights = getWeights(0);
        int startNode = getMaxWeightIdx(weights);
        weights = getWeights(startNode);
        return weights[getMaxWeightIdx(weights)];
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            int src = Integer.parseInt(inputs[0]) - 1;
            for (int j = 2; j < inputs.length - 1; j += 2) {
                int node = Integer.parseInt(inputs[j - 1]) - 1;
                int weight = Integer.parseInt(inputs[j]);
                adjList.get(src).add(new Integer[]{node, weight});
            }
        }
        Back1167 back1167 = new Back1167(n, adjList);
        writer.write(back1167.getDiameter() + "\n");
        writer.flush();
    }
}
