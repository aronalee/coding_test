// prob: https://www.acmicpc.net/problem/1668

package random_depense.back1668;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heights.add(Integer.parseInt(reader.readLine()));
        }
        Back1668 back1668 = new Back1668();
        int countOfRight = back1668.getVisibleCountAboutRight(heights);
        int countOfLeft = back1668.getVisibleCountAboutLeft(heights);
        writer.write(countOfLeft + "\n" + countOfRight);
        writer.flush();
    }
}
