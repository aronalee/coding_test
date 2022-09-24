// prob: https://www.acmicpc.net/problem/1253

package backjoon.back1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Back1253 {
    private final int[] numbers;

    public Back1253(int[] numbers) {
        Arrays.sort(numbers);
        this.numbers = numbers;
    }

    public int countGoodNumbers() {
        int count = 0;
        for (int idx = numbers.length - 1; idx >= 0; idx--) {
            int dest = numbers[idx];
            int startIdx = 0;
            int endIdx = numbers.length - 1;
            while (startIdx < endIdx) {
                if (startIdx == idx) {
                    startIdx++;
                    continue;
                } else if (endIdx == idx) {
                    endIdx--;
                    continue;
                }
                int result = numbers[startIdx] + numbers[endIdx];
                if (result == dest) {
                    count++;
                    break;
                } else if (result > dest) {
                    endIdx--;
                } else {
                    startIdx++;
                }
            }
        }
        return count;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int countNumbers = Integer.parseInt(reader.readLine());
        int[] numbers = new int[countNumbers];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < countNumbers; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Back1253 back1253 = new Back1253(numbers);
        int count = back1253.countGoodNumbers();
        writer.write("" + count);
        writer.flush();
    }
}
