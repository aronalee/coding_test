// prob: https://www.acmicpc.net/problem/4949

package backjoon.back4949;

import java.io.*;
import java.util.Stack;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean correctBracket(String line) {
        Stack<Character> stack = new Stack<>();
        for (char c : line.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        while (!line.equals(".")) {
            writer.write(correctBracket(line) ? "yes" : "no");
            writer.write("\n");
            line = reader.readLine();
        }
        writer.flush();
    }
}
