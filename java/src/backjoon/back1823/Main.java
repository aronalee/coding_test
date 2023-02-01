// prob: https://www.acmicpc.net/problem/1823

package backjoon.back1823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Integer> rices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int rice = Integer.parseInt(reader.readLine());
            rices.add(rice);
        }
        Back1823 back1823 = new Back1823(rices);
        int result = back1823.createAnswer();
        writer.write(result + "");
        writer.flush();
    }
}
