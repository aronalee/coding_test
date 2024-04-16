// prob: https://www.acmicpc.net/problem/2263성

package backjoon.back2263;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int nodeTotal = Integer.parseInt(reader.readLine());
        List<Integer> sequenceInOrder = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        List<Integer> sequencePostOrder = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Back2263 back2263 = new Back2263(nodeTotal, sequenceInOrder, sequencePostOrder);
        List<Integer> sequencePreOrder = back2263.computeSequencePreOrder();
        writer.write(sequencePreOrder.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        writer.flush();
    }
}
