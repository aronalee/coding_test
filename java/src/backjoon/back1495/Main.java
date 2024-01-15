// prob: https://www.acmicpc.net/problem/1495

package backjoon.back1495;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        List<Integer> volumes = new ArrayList<>();
        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            volumes.add(Integer.parseInt(input[i]));
        }
        Back1495 back1495 = new Back1495(volumes);
        int maxVolume = back1495.findMaxVolume(s, m);
        if (maxVolume == Back1495.EMPTY) {
            writer.write(-1 + "\n");
            writer.flush();
            return;
        }
        writer.write(maxVolume + "\n");
        writer.flush();
    }
}
