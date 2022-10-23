// prob: https://www.acmicpc.net/problem/13251

package backjoon.back13251;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(reader.readLine());
        double[] colors = new double[m + 1];
        String[] tmp = reader.readLine().split(" ");
        double n = 0;
        for (int i = 0; i < tmp.length; i++) {
            colors[i + 1] = Double.parseDouble(tmp[i]);
            n += colors[i + 1];
        }
        int k = Integer.parseInt(reader.readLine());

        double result = 0;
        for (int i = 1; i < colors.length; i++) {
            double acc = 1;
            double color = colors[i];
            for (int j = 0; j < k; j++) {
                acc *= (color - j) / (n - j);
            }
            result += acc;
        }
        writer.write(result + "\n");
        writer.flush();
    }
}
