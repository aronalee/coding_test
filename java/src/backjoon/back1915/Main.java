// prob: https://www.acmicpc.net/problem/1915

package backjoon.back1915;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int getMaxRectArea(int[][] board) {
        int maxArea = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1])) + 1;
                maxArea = Math.max(maxArea, board[i][j]);
            }
        }
        if (maxArea == 0) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 1) {
                    maxArea = 1;
                    break;
                }
            }
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == 1) {
                    maxArea = 1;
                    break;
                }
            }
        }
        return maxArea * maxArea;
    }

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            tmp = reader.readLine().split("");
            for (int j = 0; j < tmp.length; j++) {
                board[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        int result = getMaxRectArea(board);
        writer.write(result + "\n");
        writer.flush();
    }
}
