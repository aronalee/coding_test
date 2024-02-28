// prob: https://www.acmicpc.net/problem/10211

package backjoon.back10211;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalTestCases = Integer.parseInt(reader.readLine());
        List<List<Integer>> testCases = new LinkedList<>();
        for (int i = 0; i < totalTestCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            String[] input = reader.readLine().split(" ");
            List<Integer> sequence = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                sequence.add(Integer.parseInt(input[j]));
            }
            testCases.add(sequence);
        }
        Back10211 back10211 = new Back10211();
        for (List<Integer> testCase : testCases) {
            int maxSum = back10211.computeMaxSum(testCase);
            writer.write(maxSum + "\n");
        }
        writer.flush();
    }

}
