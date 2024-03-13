// prob: https://www.acmicpc.net/problem/19949

package backjoon.back19949;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<Integer> answers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Back19949 back19949 = new Back19949(5);
        long count = back19949.countAllCases(answers);
        writer.write(count + "\n");
        writer.flush();
    }

}
