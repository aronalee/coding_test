// prob: https://www.acmicpc.net/problem/6593

package backjoon.back6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {

    private final int z;
    private final int y;
    private final int x;
    private final int time;

    public Node(final int z, final int y, final int x, final int time) {
        this.z = z;
        this.y = y;
        this.x = x;
        this.time = time;
    }

    public int getZ() {
        return z;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getTime() {
        return time;
    }
}

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));
    private static final int[][] DISTANCES = new int[][]{
        {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}
    };

    public static void main(String[] args) throws IOException {
        while (true) {
            String line = reader.readLine();
            if (line.matches("^0 0 0$")) {
                break;
            }
            String[] splitEmptyChar = line.split(" ");
            int l = Integer.parseInt(splitEmptyChar[0]);
            int r = Integer.parseInt(splitEmptyChar[1]);
            int c = Integer.parseInt(splitEmptyChar[2]);
            char[][][] building = new char[l][r][c];
            Node start = new Node(0, 0, 0, 0);
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < r; j++) {
                    splitEmptyChar = reader.readLine().split("");
                    for (int k = 0; k < splitEmptyChar.length; k++) {
                        building[i][j][k] = splitEmptyChar[k].charAt(0);
                        if (building[i][j][k] == 'S') {
                            start = new Node(i, j, k, 0);
                        }
                    }
                }
                reader.readLine();
            }
            int minTime = getMinTime(new boolean[l][r][c], building, start);
            if (minTime == -1) {
                writer.write(String.format("Trapped!%n"));
                continue;
            }
            writer.write(String.format("Escaped in %d minute(s).%n", minTime));
        }
        writer.flush();
    }

    private static int getMinTime(final boolean[][][] visited, final char[][][] building,
        final Node start) {
        int result = -1;
        Queue<Node> queue = new LinkedList<>();
        visited[start.getZ()][start.getY()][start.getX()] = true;
        queue.add(start);
        while (!queue.isEmpty()) {
            Node now = queue.remove();
            for (final int[] distance : DISTANCES) {
                int nextZ = now.getZ() + distance[0];
                int nextY = now.getY() + distance[1];
                int nextX = now.getX() + distance[2];
                if (nextZ < 0 || nextZ >= building.length) {
                    continue;
                }
                if (nextY < 0 || nextY >= building[nextZ].length) {
                    continue;
                }
                if (nextX < 0 || nextX >= building[nextZ][nextY].length) {
                    continue;
                }
                if (visited[nextZ][nextY][nextX]) {
                    continue;
                }
                switch (building[nextZ][nextY][nextX]) {
                    case '#':
                        continue;
                    case 'E':
                        result = now.getTime() + 1;
                        queue.clear();
                        break;
                    case '.':
                        visited[nextZ][nextY][nextX] = true;
                        queue.add(new Node(nextZ, nextY, nextX, now.getTime() + 1));
                        break;
                }
            }
        }
        return result;
    }
}
