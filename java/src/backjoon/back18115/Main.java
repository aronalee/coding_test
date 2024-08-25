// prob: https://github.com/tony9402/baekjoon/blob/main/picked.md

package backjoon.back18115;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // Not used
        reader.readLine();

        List<Integer> actions = Arrays.stream(reader.readLine().split(" "))
            .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Back18115 back18115 = new Back18115();
        List<Integer> initBatch = back18115.computeInitBatch(actions);
        for (Integer batch : initBatch) {
            writer.write(batch + " ");
        }
        writer.newLine();
        writer.flush();
    }
}
