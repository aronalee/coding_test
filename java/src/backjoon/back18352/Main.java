// prob: https://www.acmicpc.net/problem/18352

package backjoon.back18352;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<List<Integer>> adjList = new ArrayList<>();

    private static List<Integer> getCities(boolean[] visited, int size, int k, int x) {
        int[] minDistances = new int[size];
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{x, 0});
        while (!queue.isEmpty()) {
            Integer[] info = queue.remove();
            int node = info[0];
            int distance = info[1];
            if (visited[node])
                continue;
            visited[node] = true;
            minDistances[node] = distance;
            if (distance == k)
                continue;
            for (Integer adjNode : adjList.get(node)) {
                if (visited[adjNode])
                    continue;
                queue.add(new Integer[]{adjNode, distance + 1});
            }
        }
        List<Integer> cities = new ArrayList<>();
        for (int i = 0; i < minDistances.length; i++) {
            if (minDistances[i] == k)
                cities.add(i);
        }
        return cities;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        int x = Integer.parseInt(tmp[3]);
        for (int i = 0; i < n + 1; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int node1 = Integer.parseInt(tmp[0]);
            int node2 = Integer.parseInt(tmp[1]);
            adjList.get(node1).add(node2);
        }
        List<Integer> cities = getCities(new boolean[n + 1], n + 1, k, x);
        if (cities.size() == 0) {
            writer.write("-1");
        } else {
            for (Integer city : cities) {
                writer.write(city + "\n");
            }
        }
        writer.flush();
    }
}
