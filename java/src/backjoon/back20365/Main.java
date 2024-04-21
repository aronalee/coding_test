// prob: https://www.acmicpc.net/problem/20365

package backjoon.back20365;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        reader.readLine();
        List<String> colors = new ArrayList<>();
        colors.addAll(Arrays.asList(reader.readLine().split("")));
        Back20365 back20365 = new Back20365();
        int count = back20365.computeFilledColors(colors);
        writer.write(String.valueOf(count));
        writer.flush();
    }
}
