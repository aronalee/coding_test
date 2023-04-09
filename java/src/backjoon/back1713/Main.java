// prob: https://www.acmicpc.net/problem/1713

package backjoon.back1713;

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
        int n = Integer.parseInt(reader.readLine());
        int _m = Integer.parseInt(reader.readLine());
        String[] votes = reader.readLine().split(" ");
        Back1713 back1713 = new Back1713();
        List<Integer> answers = back1713.getAnswer(n, votes);
        for (Integer answer : answers) {
            writer.write(answer + " ");
        }
        writer.flush();
    }

}
