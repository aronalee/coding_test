// prob: https://www.acmicpc.net/problem/17390

package backjoon.back17390;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int questionTotal = Integer.parseInt(inputs[1]);
        List<Integer> sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<String[]> questions = reader.lines().limit(questionTotal)
                .map(line -> line.split(" ")).collect(Collectors.toList());
        sequence.sort(Integer::compareTo);
        Back17390 back17390 = new Back17390(sequence);

        for (String[] question : questions) {
            int start = Integer.parseInt(question[0]);
            int end = Integer.parseInt(question[1]);
            int result = back17390.computeSum(start, end);
            writer.write(result + "\n");
        }
        writer.flush();
    }
}
