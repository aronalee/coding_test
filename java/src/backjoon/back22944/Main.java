// prob: https://www.acmicpc.net/problem/22944

package backjoon.back22944;

import java.io.*;
import java.util.NoSuchElementException;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int d = Integer.parseInt(input[2]);
        int[][] map = new int[n][n];
        Point startPoint = Point.EMPTY;
        for (int row = 0; row < n; row++) {
            input = reader.readLine().split("");
            for (int column = 0; column < input.length; column++) {
                switch (input[column]) {
                    case "S":
                        startPoint = new Point(row, column);
                        break;
                    case "U":
                        map[row][column] = Point.UMBRELLA_POINT;
                        break;
                    case "E":
                        map[row][column] = Point.SAFE_POINT;
                        break;
                    default:
                        map[row][column] = Point.DANGER_POINT;
                        break;
                }
            }
        }
        Back22944 back22944 = new Back22944(h, d, map);
        try {
            int countOfMinMoving = back22944.findCountOfMinMoving(startPoint);
            writer.write(countOfMinMoving + "\n");
        } catch (NoSuchElementException e) {
            writer.write("-1\n");
        }
        writer.flush();
    }

}
