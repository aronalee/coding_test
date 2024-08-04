// prob: https://www.acmicpc.net/problem/16174

package random_depence.back16174;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        Back16174 back16174=new Back16174();
        boolean isWin = back16174.isWinGame(map);
        writer.write(isWin? "HaruHaru" :"Hing");
        writer.newLine();
        writer.flush();
    }
}
