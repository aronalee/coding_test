// prob: https://www.acmicpc.net/problem/1260

package backjoon.back1260;

import java.io.*;
import java.util.*;


class Back1260 {

    private final int startNumber;
    private final boolean[][] adjArray;

    Back1260(int startNumber, boolean[][] adjArray) {
        this.startNumber = startNumber;
        this.adjArray = adjArray;
    }

    private void searchDFS(int node, boolean[] visited, List<Integer> log) {
        if (visited[node])
            return;
        visited[node] = true;
        log.add(node);
        for (int child = 1; child < adjArray[node].length; child++) {
            if (!this.adjArray[node][child] || child == node)
                continue;
            searchDFS(child, visited, log);
        }
    }

    public List<Integer> searchDFS(boolean[] visited) {
        List<Integer> log = new ArrayList<>();
        searchDFS(this.startNumber, visited, log);
        return log;
    }

    public List<Integer> searchBFS(boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> log = new ArrayList<>();
        queue.add(this.startNumber);
        while (!queue.isEmpty()) {
            int node = queue.remove();
            if (visited[node])
                continue;
            visited[node] = true;
            log.add(node);
            for (int child = 1; child < adjArray[node].length; child++) {
                if (!this.adjArray[node][child] || child == node)
                    continue;
                queue.add(child);
            }
        }
        return log;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int v = Integer.parseInt(tokenizer.nextToken());
        boolean[][] adjArr = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());
            adjArr[node1][node2] = true;
            adjArr[node2][node1] = true;
        }
        Back1260 back1260 = new Back1260(v, adjArr);
        List<Integer> logDFS = back1260.searchDFS(new boolean[n + 1]);
        List<Integer> logBFS = back1260.searchBFS(new boolean[n + 1]);
        for (Integer log : logDFS) {
            writer.write(log + " ");
        }
        writer.write("\n");
        for (Integer log : logBFS) {
            writer.write(log + " ");
        }
        writer.write("\n");
        writer.flush();
    }
}
