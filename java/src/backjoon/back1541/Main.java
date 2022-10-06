package backjoon.back1541;

import java.io.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String sequence = reader.readLine();
        int[] numbers = Pattern.compile("(?<mark>[+\\-]*)(?<number>\\d+)")
                .matcher(sequence)
                .results()
                .map(MatchResult::group)
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = 0;
        int pivort = 0;
        int number = numbers[pivort];
        while (number > 0 && pivort < numbers.length) {
            number = numbers[pivort];
            sum += number;
            pivort++;
        }
        for (int idx = pivort; idx < numbers.length; idx++) {
            number = numbers[idx];
            sum += (number > 0) ? -number : number;
        }
        writer.write(sum + "\n");
        writer.flush();
    }
}
