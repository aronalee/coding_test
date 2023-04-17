// prob: https://www.acmicpc.net/problem/10866

package backjoon.back10866;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static final Deque<Integer> deque = new LinkedList<>();
    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Token token = Token.of(reader.readLine());
            String result = executeToken(token);
            if (result.isEmpty()) {
                continue;
            }
            writer.write(result + "\n");
        }
        writer.flush();
    }

    private static String executeToken(Token token) {
        switch (token.command) {
            case PUSH_FRONT:
                deque.addFirst(token.value);
                return "";
            case PUSH_BACK:
                deque.addLast(token.value);
                return "";
            case POP_FRONT:
                if (deque.isEmpty()) {
                    return "-1";
                }
                return deque.removeFirst().toString();
            case POP_BACK:
                if (deque.isEmpty()) {
                    return "-1";
                }
                return deque.removeLast().toString();
            case SIZE:
                return Integer.toString(deque.size());
            case EMPTY:
                if (deque.isEmpty()) {
                    return "1";
                }
                return "0";
            case BACK:
                if (deque.isEmpty()) {
                    return "-1";
                }
                return deque.peekLast().toString();
            case FRONT:
                if (deque.isEmpty()) {
                    return "-1";
                }
                return deque.peekFirst().toString();
        }
        throw new IllegalArgumentException();
    }

    private enum COMMAND {
        PUSH_FRONT,
        PUSH_BACK,
        POP_FRONT,
        POP_BACK,
        SIZE,
        EMPTY,
        BACK,
        FRONT
    }

    private static class Token {

        private final COMMAND command;
        // 비어있을 수 있다.
        private Integer value = 0;

        private Token(COMMAND command, int value) {
            this.command = command;
            this.value = value;
        }

        public Token(COMMAND command) {
            this.command = command;
        }

        public static Token of(String line) {
            Token token = null;
            String[] splitLine = line.split(" ");
            int value = 0;
            if (splitLine.length == 2) {
                value = Integer.parseInt(splitLine[1]);
            }
            switch (splitLine[0]) {
                case "push_front":
                    token = new Token(COMMAND.PUSH_FRONT, value);
                    break;
                case "push_back":
                    token = new Token(COMMAND.PUSH_BACK, value);
                    break;
                case "pop_front":
                    token = new Token(COMMAND.POP_FRONT, value);
                    break;
                case "pop_back":
                    token = new Token(COMMAND.POP_BACK, value);
                    break;
                case "size":
                    token = new Token(COMMAND.SIZE);
                    break;
                case "empty":
                    token = new Token(COMMAND.EMPTY);
                    break;
                case "front":
                    token = new Token(COMMAND.FRONT);
                    break;
                case "back":
                    token = new Token(COMMAND.BACK);
                    break;
            }
            if (token == null) {
                throw new IllegalArgumentException();
            }
            return token;
        }
    }
}
