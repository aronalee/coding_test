// prob: https://www.acmicpc.net/problem/1083

package backjoon.back1083;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new LinkedList<>();
        String[] splitLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(splitLine[i]);
            numbers.add(number);
        }
        int s = Integer.parseInt(reader.readLine());
        Back1083 back1083 = new Back1083();
        List<Integer> answer = back1083.createAnswer(numbers, s);
        for (Integer value : answer) {
            writer.write(value + " ");
        }
        writer.flush();
    }
}
