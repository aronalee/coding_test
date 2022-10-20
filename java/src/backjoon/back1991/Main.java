// prob: https://www.acmicpc.net/problem/1991

package backjoon.back1991;

import java.io.*;


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] binaryTree;

    private static String indexToString(int index) {
        return Character.toString((char) index + 'A' - 1);
    }

    private static void preOrder(StringBuilder builder, int parent) {
        builder.append(indexToString(parent));
        for (int child : binaryTree[parent]) {
            if (child == 0)
                continue;
            preOrder(builder, child);
        }
    }

    private static void inOder(StringBuilder builder, int parent) {
        if (binaryTree[parent][0] != 0)
            inOder(builder, binaryTree[parent][0]);
        builder.append(indexToString(parent));
        if (binaryTree[parent][1] != 0)
            inOder(builder, binaryTree[parent][1]);
    }

    private static void postOrder(StringBuilder builder, int parent) {
        for (int child : binaryTree[parent]) {
            if (child == 0)
                continue;
            postOrder(builder, child);
        }
        builder.append(indexToString(parent));
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        binaryTree = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            String[] tmp = reader.readLine().split(" ");
            int parent = tmp[0].charAt(0) - 'A' + 1;
            if (!tmp[1].equals(".")) {
                int childLeft = tmp[1].charAt(0) - 'A' + 1;
                binaryTree[parent][0] = childLeft;
            }
            if (!tmp[2].equals(".")) {
                int childRight = tmp[2].charAt(0) - 'A' + 1;
                binaryTree[parent][1] = childRight;
            }
        }
        StringBuilder preOrderBuilder = new StringBuilder();
        StringBuilder inOrderBuilder = new StringBuilder();
        StringBuilder postOrderBuilder = new StringBuilder();

        preOrder(preOrderBuilder, 1);
        preOrderBuilder.append("\n");

        inOder(inOrderBuilder, 1);
        inOrderBuilder.append("\n");

        postOrder(postOrderBuilder, 1);
        postOrderBuilder.append("\n");
        writer.write(preOrderBuilder.toString());
        writer.write(inOrderBuilder.toString());
        writer.write(postOrderBuilder.toString());
        writer.flush();
    }
}
