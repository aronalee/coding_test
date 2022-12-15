// prob: https://www.acmicpc.net/problem/17387

package backjoon.back17387;

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
        String[] splitLine1 = reader.readLine().split(" ");
        String[] splitLine2 = reader.readLine().split(" ");
        long[][] line1 = new long[2][2];
        long[][] line2 = new long[2][2];
        int splitIdx = 0;
        for (int i = 0; i < line1.length; i++) {
            line1[i][0] = Integer.parseInt(splitLine1[splitIdx]);
            line1[i][1] = Integer.parseInt(splitLine1[splitIdx + 1]);
            splitIdx += 2;
        }
        splitIdx = 0;
        for (int i = 0; i < line2.length; i++) {
            line2[i][0] = Integer.parseInt(splitLine2[splitIdx]);
            line2[i][1] = Integer.parseInt(splitLine2[splitIdx + 1]);
            splitIdx += 2;
        }
        Back17387 back17387 = new Back17387(line1, line2);
        int answer = back17387.getAnswer();
        writer.write(answer + "\n");
        writer.flush();
    }
}
