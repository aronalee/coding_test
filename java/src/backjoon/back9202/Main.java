// prob: https://www.acmicpc.net/problem/9202

package backjoon.back9202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<String> dict = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dict.add(reader.readLine());
        }
        reader.readLine();
        Back9202 back9202 = new Back9202(dict);
        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            char[][] map = new char[4][4];
            for (int j = 0; j < 4; j++) {
                String word = reader.readLine();
                map[j] = word.toCharArray();
            }
            if (i < n - 1) {
                reader.readLine();
            }
            List<Object> result = back9202.simulateBoggleGame(map);
            writer.write(String.format("%d %s %d", (Integer) result.get(0), result.get(1),
                (Long) result.get(2)));
            writer.newLine();
        }
        writer.flush();
    }
}
