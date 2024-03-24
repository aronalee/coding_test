// prob: https://www.acmicpc.net/problem/15918

package random_depnence.back15198;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);
        Back15198 back15198 = new Back15198(n, x - 1, y - 1);
        int count = back15198.countLanPerdenSequence();
        writer.write(count + "\n");
        writer.flush();
    }
}
