// prob: https://www.acmicpc.net/problem/1377

package backjoon.back1377;

import java.io.*;
import java.util.Arrays;

class Node implements Comparable<Node> {
    private final int idx;
    private final int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    public int getIdx() {
        return idx;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, Integer.parseInt(reader.readLine()));
        }
        Arrays.sort(nodes);
        int countMaxLoop = 0;
        for (int idx = 0; idx < nodes.length; idx++) {
            if (countMaxLoop < nodes[idx].getIdx() - idx)
                countMaxLoop = nodes[idx].getIdx() - idx;
        }
        writer.write((countMaxLoop + 1) + "\n");
        writer.flush();
    }
}
