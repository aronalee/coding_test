// prob: https://www.acmicpc.net/problem/12931

package backjoon.back12931;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] targetArray = new int[n];
        String[] splitLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            targetArray[i] = Integer.parseInt(splitLine[i]);
        }
        Back12931 back12931 = new Back12931();
        int result = back12931.getMinimumCountInTargetArray(targetArray);
        writer.write(result + "\n");
        writer.flush();
    }

}
