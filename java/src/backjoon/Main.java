// prob: https://www.acmicpc.net/problem/12871

package backjoon;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        Back12871 back12871 = new Back12871();
        boolean result = back12871.isContainStrings(s1, s2);
        writeBuffer(result);
        writer.flush();
    }

    private static void writeBuffer(boolean result) throws IOException {
        if (result) {
            writer.write("1");
            return;
        }
        writer.write("0");
    }
}