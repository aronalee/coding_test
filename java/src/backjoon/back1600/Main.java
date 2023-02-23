// prob: https://www.acmicpc.net/problem/1600

package backjoon.back1600;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(reader.readLine());
        String[] splitLine = reader.readLine().split(" ");
        int W = Integer.parseInt(splitLine[0]);
        int H = Integer.parseInt(splitLine[1]);
        int[][] map = new int[H][W];
        for (int h = 0; h < H; h++) {
            splitLine = reader.readLine().split(" ");
            for (int w = 0; w < splitLine.length; w++) {
                map[h][w] = Integer.parseInt(splitLine[w]);
            }
        }
        Back1600 back1600 = new Back1600(W, H, map);
        int answer = back1600.getAnswer(k);
        writer.write(answer + "\n");
        writer.flush();
    }
}
