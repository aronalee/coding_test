// prob: https://www.acmicpc.net/problem/1158

package backjoon.back1158;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        Back1158 back1158 = new Back1158();
        List<Integer> result = back1158.getAnswer(n, k);
        writer.write("<");
        for (int i = 0; i < result.size() - 1; i++) {
            writer.write(result.get(i) + ", ");
        }
        writer.write(result.get(result.size() - 1) + ">");
        writer.flush();
    }
}
