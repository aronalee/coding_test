// prob: https://www.acmicpc.net/problem/1213

package backjoon.back1213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        Back1213 back1213 = new Back1213();
        try {
            String result = back1213.getPalindrome(line);
            writer.write(result);
        } catch (IllegalArgumentException e) {
            writer.write("I'm Sorry Hansoo\n");
        }
        writer.flush();
    }
}
