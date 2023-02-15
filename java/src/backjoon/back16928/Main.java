// prob: https://www.acmicpc.net/problem/16928

package backjoon.back16928;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        List<Step> ladders = new ArrayList<>();
        List<Step> snakes = new ArrayList<>();
        for (int i = 0; i < n + m; i++) {
            splitLine = reader.readLine().split(" ");
            int src = Integer.parseInt(splitLine[0]);
            int dst = Integer.parseInt(splitLine[1]);
            if (i < n) {
                Ladder ladder = Ladder.of(src, dst);
                ladders.add(ladder);
                continue;
            }
            Snake snake = Snake.of(src, dst);
            snakes.add(snake);
        }
        Back16928 back16928 = new Back16928();
        int result = back16928.getAnswer(ladders, snakes);
        writer.write(result + "\n");
        writer.flush();
    }
}
