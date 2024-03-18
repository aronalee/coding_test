// prob: https://www.acmicpc.net/problem/7682

package backjoon.back7682;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Back7682 back7682 = new Back7682();
        String input = "";
        while (!(input = reader.readLine()).equals("end")) {
            char[][] map = new char[3][3];
            String[] mapInput = input.split("");
            for (int y = 0; y < 3; y++) {
                for (int x = 0; x < 3; x++) {
                    map[y][x] = mapInput[y * 3 + x].charAt(0);
                }
            }
            writer.write(back7682.isPossible(map) ? "valid\n" : "invalid\n");
        }
        writer.flush();
    }
}
