// prob: https://www.acmicpc.net/problem/5568

package backjoon.back5568;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        List<Integer> cards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int card = Integer.parseInt(reader.readLine());
            cards.add(card);
        }
        Back5568 back5568 = new Back5568();
        int result = back5568.createSubNumbers(cards, k);
        writer.write(result + "\n");
        writer.flush();
    }

}
