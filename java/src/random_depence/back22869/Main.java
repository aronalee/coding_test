// prob: https://www.acmicpc.net/problem/22869

package random_depence.back22869;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] inputs = reader.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        int[] rocks = new int[n];
        inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            rocks[i] = Integer.parseInt(inputs[i]);
        }
        Back22869 back22869=new Back22869();
        boolean hasPath = back22869.hasRootLeftToRight(rocks,k);
        writer.write(hasPath ? "YES" : "NO");
        writer.newLine();
        writer.flush();
    }
}
