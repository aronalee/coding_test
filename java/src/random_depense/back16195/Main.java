// https://www.acmicpc.net/problem/16195

package random_depense.back16195;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<TC> cases = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            cases.add(TC.of(reader.readLine()));
        }
        Back16195 back16195 = new Back16195();
        for (TC testCase : cases) {
            long result = back16195.countAllCases(testCase.n, testCase.m);
            writer.write(result + "\n");
        }
        writer.flush();
    }

    private static class TC {
        private final int n;
        private final int m;

        private TC(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public static TC of(String line) {
            String[] split = line.split(" ");
            return new TC(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        }
    }
}

