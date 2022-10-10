// prob: https://www.acmicpc.net/problem/1325

package backjoon.back1325;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final List<List<Integer>> adjList = new ArrayList<>();

    private static void loopRelatedComputers(int start, boolean[] visited, int[] relatedComputers) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int now = queue.remove();
            for (Integer next : adjList.get(now)) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                relatedComputers[next]++;
                queue.add(next);
            }
        }
    }

    private static List<Integer> getVulnerableComputers(int size) {
        int[] relatedComputers = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            boolean[] visited = new boolean[size + 1];
            loopRelatedComputers(i, visited, relatedComputers);
        }
        int maxRelations = 0;
        for (int countRelated : relatedComputers) {
            maxRelations = Math.max(maxRelations, countRelated);
        }
        List<Integer> vulnerableComputers = new ArrayList<>();
        for (int i = 1; i < relatedComputers.length; i++) {
            int relatedComputer = relatedComputers[i];
            if (relatedComputer == maxRelations) {
                vulnerableComputers.add(i);
            }
        }
        return vulnerableComputers;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            int n1 = Integer.parseInt(tmp[0]);
            int n2 = Integer.parseInt(tmp[1]);
            adjList.get(n1).add(n2);
        }
        List<Integer> results = getVulnerableComputers(n);
        for (Integer result : results) {
            writer.write(result + " ");
        }
        writer.flush();
    }
}
