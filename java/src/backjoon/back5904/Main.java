// prob: https://www.acmicpc.net/problem/5904

package backjoon.back5904;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Back5904 back5904 = new Back5904();
        writer.write(back5904.findWordAboutSequence(n) + "\n");
        writer.flush();
    }
}
