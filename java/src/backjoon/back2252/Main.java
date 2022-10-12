// prob: https://www.acmicpc.net/problem/2252

package backjoon.back2252;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Back2252 {
    private final List<List<Integer>> adjList;

    public Back2252(List<List<Integer>> adjList) {
        this.adjList = adjList;
    }

    private void topologySort(int[] inDegrees, int person, boolean[] visited, List<Integer> sortedPeople) {
        if (visited[person])
            return;
        List<Integer> tmp = new ArrayList<>();
        visited[person] = true;
        for (Integer node : adjList.get(person)) {
            inDegrees[node] = 0;
            tmp.add(node);
        }
        for (Integer node : tmp) {
            topologySort(inDegrees, node, visited, sortedPeople);
        }
        sortedPeople.add(person);
    }

    private List<Integer> topologySort(int[] inDegrees) {
        List<Integer> sortedPeople = new ArrayList<>();
        boolean[] visited = new boolean[inDegrees.length];
        for (int i = 1; i < inDegrees.length; i++) {
            if (!visited[i] && inDegrees[i] == 0) {
                topologySort(inDegrees, i, visited, sortedPeople);
            }
        }
        return sortedPeople;
    }

    public List<Integer> getSortedPeople() {
        int[] inDegrees = new int[adjList.size()];
        for (List<Integer> people : adjList) {
            for (Integer person : people) {
                inDegrees[person]++;
            }
        }
        return topologySort(inDegrees);
    }
}


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int dst = Integer.parseInt(tmp[0]);
            int src = Integer.parseInt(tmp[1]);
            adjList.get(src).add(dst);
        }
        Back2252 back2252 = new Back2252(adjList);
        List<Integer> people = back2252.getSortedPeople();
        for (Integer person : people) {
            writer.write(person + " ");
        }
        writer.flush();
    }
}
