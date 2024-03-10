// prob: https://www.acmicpc.net/problem/19699

package random_depnence.back19699;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int _totalCows = Integer.parseInt(inputs[0]);
        int countSelectedCows = Integer.parseInt(inputs[1]);
        List<Integer> weightOfCows = new LinkedList<>();
        inputs = reader.readLine().split(" ");
        for (String input : inputs) {
            weightOfCows.add(Integer.parseInt(input));
        }
        Back19699 back19699 = new Back19699();
        List<Integer> cows = back19699.computePrimes(weightOfCows, countSelectedCows);
        if (cows.isEmpty()) {
            writer.write("-1");
        }
        for (Integer cow : cows) {
            writer.write(cow + " ");
        }
        writer.flush();
    }
}
