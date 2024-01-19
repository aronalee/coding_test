// prob: https://www.acmicpc.net/problem/18234

package backjoon.back18234;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int totalCarrot = Integer.parseInt(input[0]);
        int limitTime = Integer.parseInt(input[1]);
        List<Carrot> carrots = new ArrayList<>();
        for (int i = 0; i < totalCarrot; i++) {
            input = reader.readLine().split(" ");
            int carrot = Integer.parseInt(input[0]);
            int time = Integer.parseInt(input[1]);
            carrots.add(Carrot.of(carrot, time));
        }
        Back18234 back18234 = new Back18234();
        long result = back18234.findMaxSumCarrot(limitTime, carrots);
        writer.write(result + "\n");
        writer.flush();
    }
}
