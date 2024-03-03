// prob: https://www.acmicpc.net/problem/11256

package backjoon.back11256;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<TestCase> testCases = readTestCases();
        Back11256 back11256 = new Back11256();
        for (TestCase testCase : testCases) {
            int result = back11256.computeCountMinOfBoxes(testCase.totalCanddies, testCase.boxes);
            writer.write(result + "\n");
        }
        writer.flush();
    }

    private static List<TestCase> readTestCases() throws IOException {
        List<TestCase> testCases = new LinkedList<>();
        int totalTestCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < totalTestCases; i++) {
            String[] input = reader.readLine().split(" ");
            int totalCanddies = Integer.parseInt(input[0]);
            int totalBoxes = Integer.parseInt(input[1]);
            List<Box> boxes = new LinkedList<>();
            for (int j = 0; j < totalBoxes; j++) {
                String[] box = reader.readLine().split(" ");
                int row = Integer.parseInt(box[0]);
                int column = Integer.parseInt(box[1]);
                boxes.add(new Box(row, column));
            }
            testCases.add(new TestCase(totalCanddies, boxes));
        }
        return testCases;
    }

    private static class TestCase {
        private final int totalCanddies;
        private final List<Box> boxes;

        public TestCase(int totalCanddies, List<Box> boxes) {
            this.totalCanddies = totalCanddies;
            this.boxes = boxes;
        }
    }
}
