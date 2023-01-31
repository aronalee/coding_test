// prob: https://www.acmicpc.net/problem/2559

package backjoon.back2559;

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
        String[] splitLine = reader.readLine().split(" ");
        int k = Integer.parseInt(splitLine[1]);
        List<Integer> numbers = new ArrayList<>();
        for (String value : reader.readLine().split(" ")) {
            numbers.add(Integer.parseInt(value));
        }
        Back2559 back2559 = new Back2559();
        int answer = back2559.getAnswer(numbers, k);
        writer.write(answer + "\n");
        writer.flush();
    }
}
