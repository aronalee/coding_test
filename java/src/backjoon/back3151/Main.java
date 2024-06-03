// prob: https://www.acmicpc.net/problem/3151

package backjoon.back3151;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        reader.readLine();
        List<Integer> sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Back3151 back3151 = new Back3151();
        long zeroSumCount = back3151.computeSumIsZero(sequence);
        writer.write(zeroSumCount + "\n");
        writer.flush();
    }
}
