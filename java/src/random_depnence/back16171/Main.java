// prob: https://www.acmicpc.net/problem/16171

package random_depnence.back16171;

import java.io.*;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String note = reader.readLine();
        String keyword = reader.readLine();
        Back16171 back16171 = new Back16171(note);
        if (back16171.hasKeyword(keyword)) {
            writer.write("1");
        } else {
            writer.write("0");
        }
        writer.flush();
    }
}
