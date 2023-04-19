// prob: https://www.acmicpc.net/problem/17451

package backjoon.back17451;

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
        int n = Integer.parseInt(reader.readLine());
        Back17451 back17451 = new Back17451();
        String[] splitLine = reader.readLine().split(" ");
        List<Long> speeds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            speeds.add(Long.parseLong(splitLine[i]));
        }
        long result = back17451.getAnswer(speeds);
        writer.write(result + "\n");
        writer.flush();
    }
}
