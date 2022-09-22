// prob: https://www.acmicpc.net/problem/1546

package backjoon.back1546;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static double getMax(double[] array) {
        double maxValue = Integer.MIN_VALUE;
        for (double value : array) {
            maxValue = Math.max(value, maxValue);
        }
        return maxValue;
    }

    private static double getAverage(double[] array) {
        double avg = 0;
        for (double value :
                array) {
            avg += value;
        }
        avg /= array.length;
        return avg;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] scoresByString = reader.readLine().split(" ");
        double[] scores = new double[n];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Double.parseDouble(scoresByString[i]);
        }
        double maxValue = getMax(scores);
        for (int i = 0; i < scores.length; i++) {
            scores[i] = scores[i] / maxValue * 100;
        }
        double avg = getAverage(scores);
        writer.write(String.format("%f", avg));
        writer.flush();
    }
}
