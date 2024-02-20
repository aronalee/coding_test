// prob: https://www.acmicpc.net/problem/6209

package backjoon.back6209;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int d = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);
        int m = Integer.parseInt(inputs[2]);
        List<Integer> rocks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rocks.add(Integer.parseInt(reader.readLine()));
        }
        Back6209 back6209 = new Back6209(d, rocks, m);
        int result = back6209.findMinDistance();
        writer.write(result + "\n");
        writer.flush();
    }
}
