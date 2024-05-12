// prob: https://www.acmicpc.net/problem/16508

package random_depnence.back16508;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String word = reader.readLine();
        Map<String, Integer> dictionary = new HashMap<>();
        int totalElements = Integer.parseInt(reader.readLine());
        for (int i = 0; i < totalElements; i++) {
            String[] input = reader.readLine().split(" ");
            int price = Integer.parseInt(input[0]);
            String element = input[1];
            dictionary.put(element, price);
        }
        Back16508 back16508 = new Back16508();
        int result = back16508.computeMinPrice(word, dictionary);
        writer.write(result + "\n");
        writer.flush();
    }
}
