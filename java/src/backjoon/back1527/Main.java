// prob: https://www.acmicpc.net/problem/1527

package backjoon.back1527;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        long min = Long.parseLong(splitLine[0]);
        long max = Long.parseLong(splitLine[1]);
        Back1527 back1527 = new Back1527();
        int totalKimNumbers = back1527.countKimNumbers(min, max);
        writer.write(String.valueOf(totalKimNumbers));
        writer.flush();
    }
}
