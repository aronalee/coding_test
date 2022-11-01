// prob: https://www.acmicpc.net/problem/11049

package backjoon.back11049;

import java.io.*;

class Matrix {
    private final int m;
    private final int n;

    public Matrix(int m, int n) {
        this.m = m;
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int countOp(Matrix[] matrices, int[][] m, int x, int y) {
        if (m[x][y] != 0) {
            return m[x][y];
        } else if (x >= y) {
            return 0;
        } else if (y - x == 1) {
            return m[x][y] = matrices[x].getM() * matrices[x].getN() * matrices[y].getN();
        }
        m[x][y] = Integer.MAX_VALUE;
        for (int i = x; i < y; i++) {
            int result = countOp(matrices, m, x, i) + countOp(matrices, m, i + 1, y)
                    + matrices[x].getM() * matrices[i].getN() * matrices[y].getN();
            m[x][y] = Math.min(m[x][y], result);
        }
        return m[x][y];
    }

    private static int countMatrixMulOperation(Matrix[] matrices) {
        int[][] m = new int[matrices.length][matrices.length];
        return countOp(matrices, m, 1, matrices.length - 1);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Matrix[] matrices = new Matrix[n + 1];
        for (int i = 1; i < matrices.length; i++) {
            String[] tmp = reader.readLine().split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            matrices[i] = new Matrix(x, y);
        }
        int result = countMatrixMulOperation(matrices);
        writer.write(result + "\n");
        writer.flush();
    }
}
