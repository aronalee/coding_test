// prob: https://www.acmicpc.net/problem/11720

package backjoon.back11720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        long sum = 0;
        reader.readLine();
        for (char c : reader.readLine().toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        writer.write(String.format("%d\n", sum));
        writer.flush();
    }
}
