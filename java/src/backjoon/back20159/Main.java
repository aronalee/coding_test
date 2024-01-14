// prob: https://www.acmicpc.net/problem/20159

package backjoon.back20159;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalCards = Integer.parseInt(reader.readLine());
        List<Integer> cards = new ArrayList<>();
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < totalCards; i++) {
            cards.add(Integer.parseInt(input[i]));
        }
        Back20159 back20159 = new Back20159();
        int result = back20159.findMaxSum(cards);
        writer.write(result + "\n");
        writer.flush();
    }
}
