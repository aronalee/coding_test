// prob: https://www.acmicpc.net/problem/1717

package backjoon.back1717;

import java.io.*;
import java.util.Arrays;

enum OPERATION {
    UNION,
    FIND,
}

class Back1717 {
    private final int[] rootMatrix;

    public Back1717(int[] rootMatrix) {
        this.rootMatrix = rootMatrix;
    }

    public void union(int x, int y) {
        while (rootMatrix[x] != x) {
            x = rootMatrix[x];
        }
        while (rootMatrix[y] != y) {
            y = rootMatrix[y];
        }
        int root = Math.min(x, y);
        int child = Math.max(x, y);
        rootMatrix[child] = root;
    }

    public int find(int x) {
        if (rootMatrix[x] == x)
            return x;
        int root = find(rootMatrix[x]);
        rootMatrix[x] = root;
        return root;
    }

}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int[] rootMaterix = new int[n + 1];
        Arrays.setAll(rootMaterix, p -> p);
        Back1717 back1717 = new Back1717(rootMaterix);
        for (int i = 0; i < m; i++) {
            tmp = reader.readLine().split(" ");
            OPERATION op = (tmp[0].equals("0")) ? OPERATION.UNION : OPERATION.FIND;
            int x = Integer.parseInt(tmp[1]);
            int y = Integer.parseInt(tmp[2]);
            switch (op) {
                case UNION:
                    back1717.union(x, y);
                    break;
                case FIND:
                    String result = (back1717.find(x) == back1717.find(y)) ? "YES" : "NO";
                    writer.write(result + "\n");
                    break;
            }
        }
        writer.flush();
    }
}
