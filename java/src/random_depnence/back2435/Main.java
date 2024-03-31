// prob: https://www.acmicpc.net/problem/2435능

package random_depnence.back2435;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> temperatures = List.of();
        int k = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            k = Integer.parseInt(input[1]);
            temperatures = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        }
        int[] sumSubSequences = new int[temperatures.size() - k + 1];
        int tmp = 0;
        for (int i = 0; i < k; i++) {
            tmp += temperatures.get(i);
        }
        sumSubSequences[0] = tmp;
        for (int i = 1; i < sumSubSequences.length; i++) {
            sumSubSequences[i] = sumSubSequences[i - 1] + temperatures.get(k - 1 + i) - temperatures.get(i - 1);
        }
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            writer.write(Arrays.stream(sumSubSequences).max().getAsInt() + "");
            writer.flush();
        }
    }
}
