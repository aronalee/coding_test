// prob: https://www.acmicpc.net/problem/12919

package backjoon.back12919;

import backjoon.Back12919;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String startWord = reader.readLine();
        String targetWord = reader.readLine();
        Back12919 back12919 = new Back12919();
        writer.write(back12919.isMakeTarget(startWord, targetWord) ? "1" : "0");
        writer.flush();
    }
}
