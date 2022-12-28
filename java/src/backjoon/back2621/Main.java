// prob: https://www.acmicpc.net/problem/2621

package backjoon.back2621;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        List<Character> colors = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String line = reader.readLine();
            String[] splitLine = line.split(" ");
            char color = splitLine[0].charAt(0);
            int number = Integer.parseInt(splitLine[1]);
            numbers.add(number);
            colors.add(color);
        }
        Back2621 back2621 = new Back2621(numbers, colors);
        writer.write(back2621.getAnswer() + "\n");
        writer.flush();
    }
}
