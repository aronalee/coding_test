// prob: https://www.acmicpc.net/problem/17298

package backjoon.back17298;

import java.io.*;
import java.util.Stack;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(input[i]);
        for (int idx = 0; idx < array.length; idx++) {
            while (!stack.isEmpty() && array[stack.peek()] < array[idx])
                array[stack.pop()] = array[idx];
            stack.push(idx);
        }
        while (!stack.empty())
            array[stack.pop()] = -1;
        for (int number : array) {
            writer.write(number + " ");
        }
        writer.flush();
    }
}

// 9 5 4 8
// 0 1 2
//9 5 8 8
// 0 1
// 9 8 8 8
// 0
// -1 8 8 -1