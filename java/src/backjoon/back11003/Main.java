// prob: https://www.acmicpc.net/problem/11003

package backjoon.back11003;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    private final int idx;
    private final int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    public int getIdx() {
        return idx;
    }

    public int getValue() {
        return value;
    }
}

class Back11003 {
    private final Deque<Node> deque = new ArrayDeque<>();
    private final int[] array;
    private final int sizeWindow;

    public Back11003(int[] array, int sizeWindow) {
        this.array = array;
        this.sizeWindow = sizeWindow;
    }

    private void add(Node node) {
        while (!this.deque.isEmpty()) {
            Node tmp = this.deque.removeLast();
            if (tmp.getValue() < node.getValue()) {
                this.deque.addLast(tmp);
                this.deque.addLast(node);
                return;
            }
        }
        this.deque.add(node);
    }

    private void filter(int location) {
        while (!this.deque.isEmpty()
                && this.deque.peekFirst().getIdx() <= location - this.sizeWindow)
            this.deque.removeFirst();
    }

    public int[] createMinValues() {
        int[] minValues = new int[array.length];
        for (int i = 0; i < this.array.length; i++) {
            Node node = new Node(i, this.array[i]);
            this.filter(i);
            this.add(node);
            minValues[i] = this.deque.getFirst().getValue();
        }
        return minValues;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int sizeWindow = Integer.parseInt(tokenizer.nextToken());
        int[] array = new int[n];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Back11003 back11003 = new Back11003(array, sizeWindow);
        int[] minValues = back11003.createMinValues();
        for (int value : minValues) {
            writer.write(value + " ");
        }
        writer.flush();
    }
}
