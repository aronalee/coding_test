// prob: https://www.acmicpc.net/problem/11724

package backjoon.back11724;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Back11724 {


    private final List<List<Integer>> nodes;
    private final boolean[] visited;

    public Back11724(List<List<Integer>> nodes, boolean[] visited) {
        this.nodes = nodes;
        this.visited = visited;
    }

    private void countArea(int id) {
        if (visited[id]) {
            return;
        }
        visited[id] = true;
        for (int i = 0; i < nodes.get(id).size(); i++) {
            countArea(nodes.get(id).get(i));
        }
    }

    public int countArea() {
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            countArea(i);
            count++;
        }
        return count;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        List<List<Integer>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        int edges = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < edges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int src = Integer.parseInt(tokenizer.nextToken()) - 1;
            int dst = Integer.parseInt(tokenizer.nextToken()) - 1;
            nodes.get(src).add(dst);
            nodes.get(dst).add(src);
        }
        Back11724 back11724 = new Back11724(nodes, new boolean[n]);
        writer.write(back11724.countArea() + "\n");
        writer.flush();
    }
}
