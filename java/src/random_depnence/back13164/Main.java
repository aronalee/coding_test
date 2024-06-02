// prob: https://www.acmicpc.net/problem/13164

package random_depnence.back13164;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int teamCount = Integer.parseInt(input[1]);
        List<Integer> sequence = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Back13164 back13164 = new Back13164();
        int result = back13164.computeMinCost(sequence, teamCount);
        writer.write(result + "\n");
        writer.flush();
    }
}
