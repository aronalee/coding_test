// prob: https://www.acmicpc.net/problem/1780

package random_depense.back1780;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] split = line.split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        Back1780 back1780 = new Back1780();
        int[] result = back1780.countOfSymbols(map);
        for (int value : result) {
            writer.write(value + "\n");
        }
        writer.flush();
    }
}
