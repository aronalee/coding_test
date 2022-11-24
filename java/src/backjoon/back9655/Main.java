// prob: https://www.acmicpc.net/problem/9655

package backjoon.back9655;

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
        int n = Integer.parseInt(reader.readLine());
        if (n % 2 == 1) {
            writer.write("SK");
            writer.flush();
            return;
        }
        writer.write("CY");
        writer.flush();
    }
}
