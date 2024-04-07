// prob: https://www.acmicpc.net/problem/12761

package random_depnence.back12761;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int m = Integer.parseInt(input[3]);
        Back12761 back12761 = new Back12761(a, b);
        int stepMin = back12761.computeStepMin(n, m);
        writer.write(stepMin + "\n");
        writer.flush();
    }
}
