// prob: https://www.acmicpc.net/problem/15721

package backjoon;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
            new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int peopleTotal = Integer.parseInt(reader.readLine());
        int target = Integer.parseInt(reader.readLine());
        int symbol = Integer.parseInt(reader.readLine());
        Back15721 back15721 = new Back15721();
        int person = back15721.findPerson(peopleTotal, target, symbol);
        writer.write(person + "\n");
        writer.flush();
    }
}
