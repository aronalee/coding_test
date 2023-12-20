// prob: https://www.acmicpc.net/problem/15806

package backjoon.back15806;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        int k = Integer.parseInt(splitLine[2]);
        int t = Integer.parseInt(splitLine[3]);
        List<Point> molds = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            splitLine = reader.readLine().split(" ");
            int x = Integer.parseInt(splitLine[0]);
            int y = Integer.parseInt(splitLine[1]);
            molds.add(Point.of(y, x));
        }
        Set<Point> pointsOfValidate = new HashSet<>();
        for (int i = 0; i < k; i++) {
            splitLine = reader.readLine().split(" ");
            int x = Integer.parseInt(splitLine[0]);
            int y = Integer.parseInt(splitLine[1]);
            pointsOfValidate.add(Point.of(y, x));
        }
        Back15806 back15806 = new Back15806(n, n, pointsOfValidate);
        boolean isCleaning = back15806.validateCleaning(molds, t);
        if (isCleaning) {
            writer.write("YES");
            writer.flush();
            return;
        }
        writer.write("NO");
        writer.flush();
    }

}
