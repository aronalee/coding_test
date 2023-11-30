// prob: https://www.acmicpc.net/problem/1699

package backjoon.back1699;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Back1699 back1699 = new Back1699();
        int result = back1699.getMinSquare(n);
        writer.write(String.valueOf(result));
        writer.flush();
    }
}
