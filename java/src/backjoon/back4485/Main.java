package backjoon.back4485;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    private final int y;
    private final int x;

    public Node(final int y, final int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final int[][] DISTANCES = new int[][]{
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0},
    };

    private static int getLostRupee(int[][] map) {
        Queue<Node> queue = new LinkedList<>();
        int[][] minRupees = new int[map.length][map.length];
        for (final int[] tuple : minRupees) {
            Arrays.fill(tuple, Integer.MAX_VALUE / 2);
        }
        minRupees[0][0] = map[0][0];
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (final int[] distance : DISTANCES) {
                int nextY = distance[0] + now.getY();
                int nextX = distance[1] + now.getX();
                if (nextY >= map.length || nextY < 0 || nextX >= map[nextY].length || nextX < 0) {
                    continue;
                }
                int subLostRupee = minRupees[now.getY()][now.getX()] + map[nextY][nextX];
                if (minRupees[nextY][nextX] <= subLostRupee) {
                    continue;
                }
                minRupees[nextY][nextX] = subLostRupee;
                queue.add(new Node(nextY, nextX));
            }
        }
        return minRupees[map.length - 1][map.length - 1];
    }

    public static void main(String[] args) throws IOException {
        int probNo = 1;
        while (true) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) {
                break;
            }
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] tmp = reader.readLine().split(" ");
                for (int j = 0; j < tmp.length; j++) {
                    map[i][j] = Integer.parseInt(tmp[j]);
                }
            }
            int result = getLostRupee(map);
            writer.write(String.format("Problem %d: %d\n", probNo, result));
            probNo++;
        }
        writer.flush();
    }
}
