// prob:https://www.acmicpc.net/problem/2630

package back2630;

import java.io.*;


enum COLOR {
    WHITE,
    BLUE;
}

class Back2630 {
    private final COLOR[][] board;
    private final int n;
    private int blue = 0;
    private int white = 0;

    public Back2630(int[][] board, int n) {
        this.board = new COLOR[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.board[i][j] = (board[i][j] == 1) ? COLOR.BLUE : COLOR.WHITE;
            }
        }
        this.n = n;
    }

    private int[] countColorsInBoard(int h, int w, int size) {
        int[] colors = new int[2];
        if (size == 1) {
            if (this.board[h][w] == COLOR.BLUE)
                colors[1] = 1;
            else
                colors[0] = 1;
            return colors;
        }
        for (int i = h; i < h + size; i += size / 2) {
            for (int j = w; j < w + size; j += size / 2) {
                int[] subColors = this.countColorsInBoard(i, j, size / 2);
                for (int k = 0; k < subColors.length; k++)
                    colors[k] += subColors[k];
            }
        }
        if (colors[0] == 4) {
            colors[0] = 1;
        } else if (colors[1] == 4) {
            colors[1] = 1;
        } else {
            this.white += colors[0];
            this.blue += colors[1];
            colors[0] = 0;
            colors[1] = 0;
        }
        return colors;
    }


    public int[] getColors() {
        int[] colors = countColorsInBoard(0, 0, this.n);
        this.white += colors[0];
        this.blue += colors[1];
        return new int[]{this.white, this.blue};
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        Back2630 back2630 = new Back2630(board, n);
        int[] colors = back2630.getColors();
        for (int color :
                colors) {
            writer.write(String.format("%d\n", color));
        }
        writer.flush();
    }
}