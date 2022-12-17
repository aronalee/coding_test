package backjoon.back2217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Long> ropes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            ropes.add(Long.parseLong(reader.readLine()));
        }
        Back2217 back2217 = new Back2217(ropes);
        long answer = back2217.getAnswer();
        writer.write(answer + "\n");
        writer.flush();
    }
}
