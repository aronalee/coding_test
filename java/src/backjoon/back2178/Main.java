// prob: https://www.acmicpc.net/problem/2178

package backjoon.back2178;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    private final int y;
    private final int x;
    private final int count;

    Node(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getCount() {
        return count;
    }
}

class Back2178 {
    private final boolean[][] matrix;
    private final int maxY;
    private final int maxX;
    private final int[][] distances = new int[][]{
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    Back2178(boolean[][] matrix, int maxY, int maxX) {
        this.matrix = matrix;
        this.maxY = maxY;
        this.maxX = maxX;
    }

    public int getOptimizedLength() {
        boolean[][] visited = new boolean[maxY][maxX];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        while (!queue.isEmpty()) {
            Node point = queue.remove();
            if (visited[point.getY()][point.getX()])
                continue;
            visited[point.getY()][point.getX()] = true;
            if (point.getY() == maxY - 1 && point.getX() == maxX - 1) {
                return point.getCount();
            }
            for (int[] distance : distances) {
                int disY = point.getY() + distance[0];
                int disX = point.getX() + distance[1];
                if (disY >= maxY || disY < 0)
                    continue;
                if (disX >= maxX || disX < 0)
                    continue;
                if (visited[disY][disX])
                    continue;
                if (!matrix[disY][disX])
                    continue;
                queue.add(new Node(disY, disX, point.getCount() + 1));
            }
        }
        throw new NullPointerException();
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        boolean[][] matrix = new boolean[n][m];
        for (int i = 0; i < matrix.length; i++) {
            String[] tuple = reader.readLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Integer.parseInt(tuple[j]) == 1;
            }
        }
        Back2178 back2178 = new Back2178(matrix, n, m);
        int length = back2178.getOptimizedLength();
        writer.write(length + "");
        writer.flush();
    }
}
