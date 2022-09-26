// prob: https://www.acmicpc.net/problem/1874

package backjoon.back1874;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        List<String> log = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        int number = 1;
        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() || array[i] != stack.peek()) {
                if (number > n) {
                    writer.write("NO");
                    writer.flush();
                    return;
                }
                log.add("+");
                stack.push(number);
                number++;
            }
            log.add("-");
            stack.pop();
        }
        for (String str : log) {
            writer.write(str + '\n');
        }
        writer.flush();
    }
}
