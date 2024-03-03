// prob: https://www.acmicpc.net/problem/1421

package backjoon.back1421;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        long totalWoods = Long.parseLong(input[0]);
        long cutCost = Long.parseLong(input[1]);
        long sellingOfOneWood = Long.parseLong(input[2]);
        List<Long> woods = new LinkedList<>();
        for (long i = 0; i < totalWoods; i++) {
            woods.add(Long.parseLong(reader.readLine()));
        }
        Back1421 back1421 = new Back1421();
        long result = back1421.computeMaxPrice(woods, cutCost, sellingOfOneWood);
        writer.write(result + "\n");
        writer.flush();
    }
}
