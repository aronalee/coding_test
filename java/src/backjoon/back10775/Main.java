// prob: https://www.acmicpc.net/problem/10775

package backjoon.back10775;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int g = Integer.parseInt(reader.readLine());
        int p = Integer.parseInt(reader.readLine());
        List<Integer> wantToParkingGateMaxNumbers = new LinkedList<>();
        for (int i = 0; i < p; i++) {
            int wantToParkingTateMaxNumber = Integer.parseInt(reader.readLine());
            wantToParkingGateMaxNumbers.add(wantToParkingTateMaxNumber);
        }
        Back10775 back10775 = new Back10775();
        int result = back10775.getMaxCountParking(g, wantToParkingGateMaxNumbers);
        writer.write(String.valueOf(result));
        writer.flush();
    }
}
