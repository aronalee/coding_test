// prob: https://www.acmicpc.net/problem/13565

package backjoon.back13565;

import java.io.*;

public class Main {

    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int[][] map = readMap();
        Back13565 back13565 = new Back13565();
        writer.write(back13565.hasElectronicPath(map) ? "YES" : "NO");
        writer.flush();
    }

    private static int[][] readMap() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] inputs = reader.readLine().split(" ");
            int row = Integer.parseInt(inputs[0]);
            int column = Integer.parseInt(inputs[1]);
            int[][] map = new int[row][column];
            for (int i = 0; i < row; i++) {
                String[] rowInfo = reader.readLine().split("");
                for (int j = 0; j < column; j++) {
                    map[i][j] = Integer.parseInt(rowInfo[j]);
                }
            }
            return map;
        }
    }

}
