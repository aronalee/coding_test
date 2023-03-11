// prob https://www.acmicpc.net/problem/1038

package backjoon.back1038;

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
        Back1038 back1038 = new Back1038();
        try {
            String result = back1038.getDescNumberAboutN(n);
            writer.write(result);
        } catch (IllegalArgumentException e) {
            writer.write("-1");
        }
        writer.flush();
    }
}
