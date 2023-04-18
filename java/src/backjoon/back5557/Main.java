// prob: https://www.acmicpc.net/problem/5557

package backjoon.back5557;

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
        int n = Integer.parseInt(reader.readLine());
        List<Integer> numbers = new ArrayList<>();
        String[] splitLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(splitLine[i]));
        }
        Back5557 back5557 = new Back5557();
        long result = back5557.getAnswer(numbers);
        writer.write(result + "\n");
        writer.flush();
    }
}
