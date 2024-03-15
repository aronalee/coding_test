// prob: https://www.acmicpc.net/problem/16472

package backjoon.back16472;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Character> sequence = Arrays.stream(reader.readLine().split(""))
                .map(s -> s.charAt(0)).collect(Collectors.toList());
        Back16472 back16472 = new Back16472();
        int lcs = back16472.findLCS(n, sequence);
        writer.write(lcs + "\n");
        writer.flush();
    }
}
