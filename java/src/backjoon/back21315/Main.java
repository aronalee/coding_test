// prob: https://www.acmicpc.net/problem/21315

package backjoon.back21315;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] cards = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(input[i]);
        }
        Back21315 back21315 = new Back21315();
        back21315.simulateShuffle(n, cards);
        writer.write(back21315.getFirstK() + " " + back21315.getSecondK());
        writer.flush();
    }
}
