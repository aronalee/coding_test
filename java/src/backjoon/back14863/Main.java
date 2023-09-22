// prob: https://www.acmicpc.net/problem/14863

package backjoon.back14863;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        String[] splitLine = line.split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int k = Integer.parseInt(splitLine[1]);
        List<City> city = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            splitLine = reader.readLine().split(" ");
            city.add(City.of(Integer.parseInt(splitLine[0]), Long.parseLong(splitLine[1]), Integer.parseInt(splitLine[2]), Long.parseLong(splitLine[3])));
        }
        Back14863 back14863 = new Back14863();
        long result = back14863.getMaxCostInCity(k, city);
        writer.write(result + "\n");
        writer.flush();
    }
}
