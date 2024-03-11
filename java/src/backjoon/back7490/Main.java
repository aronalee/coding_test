// prob: https://www.acmicpc.net/problem/7490

package backjoon.back7490;

import java.io.*;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int totalTestCases = Integer.parseInt(reader.readLine());
        Back7490 back7490 = new Back7490();
        for (int i = 0; i < totalTestCases; i++) {
            int n = Integer.parseInt(reader.readLine());
            List<OperationCase> cases = back7490.generateAllCases(n);
            cases.sort(Comparator.comparing(OperationCase::toString));
            for (OperationCase aCase : cases) {
                writer.write(aCase.toString());
                writer.newLine();
            }
            writer.newLine();
        }
        writer.flush();
    }
}
