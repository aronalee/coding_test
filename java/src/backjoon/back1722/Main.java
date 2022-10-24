// prob: https://www.acmicpc.net/problem/1722

package backjoon.back1722;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static long[] createFactorials(int n) {
        long[] factorials = new long[n];
        factorials[n - 1] = 1;
        int number = 2;
        for (int i = factorials.length - 2; i >= 0; i--) {
            factorials[i] = factorials[i + 1] * number;
            number++;
        }
        return factorials;
    }

    private static List<Integer> subProb1(int n, long k) {
        long[] factorials = createFactorials(n);
        List<Integer> list = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        long tmp = 0;
        for (int i = 1; i <= n; i++) {
            int pivort = 1;
            long factorial = i < factorials.length ? factorials[i] : 1;
            for (int j = 1; j <= n; j++) {
                if (visited[j])
                    continue;
                if (k > factorial * pivort + tmp) {
                    pivort++;
                    continue;
                }
                tmp += factorial * (pivort - 1);
                visited[j] = true;
                list.add(j);
                break;
            }
        }
        return list;
    }

    private static long subProb2(int n, List<Integer> list) {
        long[] factorials = createFactorials(n);
        long count = 1;
        boolean[] visited = new boolean[n + 1];
        for (int i = 0; i < list.size(); i++) {
            long factorial = i + 1 < factorials.length ? factorials[i + 1] : 1;
            long pivort = 0;
            for (int j = 1; j < visited.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (list.get(i) != j) {
                    pivort++;
                    continue;
                }
                visited[j] = true;
                count += factorial * pivort;
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] tmp = reader.readLine().split(" ");
        switch (Integer.parseInt(tmp[0])) {
            case 1:
                List<Integer> results = subProb1(n, Long.parseLong(tmp[1]));
                for (int result : results) {
                    writer.write(result + " ");
                }
                break;
            case 2:
                List<Integer> sequence = new ArrayList<>();
                for (int i = 1; i < tmp.length; i++) {
                    sequence.add(Integer.parseInt(tmp[i]));
                }
                long result = subProb2(n, sequence);
                writer.write(result + "");
                break;
        }
        writer.flush();
    }
}
