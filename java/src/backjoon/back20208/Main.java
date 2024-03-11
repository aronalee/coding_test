// prob: https://www.acmicpc.net/problem/20208

package backjoon.back20208;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int SYMBOL_MINT_MILK = 2;
    private static final int SYMBOL_HOUSE = 1;

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);
        int[][] map = new int[n][n];
        for (int row = 0; row < n; row++) {
            input = reader.readLine().split(" ");
            for (int column = 0; column < n; column++) {
                map[row][column] = Integer.parseInt(input[column]);
            }
        }
        int[][] adjMatrix = createAdjMatrix(map);
        int houseId = adjMatrix.length - 1;
        Back20208 back20208 = new Back20208(adjMatrix, h);
        int maxCountOfMintMilk = back20208.computeMaxCountOfMintMilk(houseId, m);
        writer.write(maxCountOfMintMilk + "\n");
        writer.flush();
    }

    private static int[][] createAdjMatrix(int[][] map) {
        List<int[]> pointsExcludeGround = findPointOfMilks(map);
        pointsExcludeGround.add(findPointOfHouse(map));
        int[][] adjMatrix = new int[pointsExcludeGround.size()][pointsExcludeGround.size()];
        for (int i = 0; i < pointsExcludeGround.size(); i++) {
            for (int j = i + 1; j < pointsExcludeGround.size(); j++) {
                int[] point1 = pointsExcludeGround.get(i);
                int[] point2 = pointsExcludeGround.get(j);
                int cost = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                adjMatrix[i][j] = cost;
                adjMatrix[j][i] = cost;
            }
        }
        return adjMatrix;
    }

    private static List<int[]> findPointOfMilks(int[][] map) {
        List<int[]> mintMilks = new LinkedList<>();
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map.length; column++) {
                if (map[row][column] == SYMBOL_MINT_MILK) {
                    mintMilks.add(new int[]{row, column});
                }
            }
        }
        return mintMilks;
    }

    private static int[] findPointOfHouse(int[][] map) {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map.length; column++) {
                if (map[row][column] == SYMBOL_HOUSE) {
                    return new int[]{row, column};
                }
            }
        }
        throw new NoSuchElementException("has not house point");
    }
}
