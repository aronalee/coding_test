// prob: https://www.acmicpc.net/problem/1931

package backjoon.back1931;

import java.io.*;
import java.util.Arrays;

class Node {
    private final int start;
    private final int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String[] tmp = reader.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
        }
        Arrays.sort(nodes, (node1, node2) -> {
            if (node1.getEnd() != node2.getEnd())
                return node1.getEnd() - node2.getEnd();
            return node1.getStart() - node2.getStart();
        });
        int count = 0;
        int end = -1;
        for (Node node : nodes) {
            if (node.getStart() < end)
                continue;
            end = node.getEnd();
            count++;
        }
        writer.write(count + "\n");
        writer.flush();
    }
}
