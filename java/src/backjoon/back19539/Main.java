// prob: https://www.acmicpc.net/problem/19539

package backjoon.back19539;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Integer> wantTreeHeight = new LinkedList<>();
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            wantTreeHeight.add(Integer.parseInt(input[i]));
        }
        Back19539 back19539 = new Back19539();
        boolean isAble = back19539.isAbleToMakeTree(wantTreeHeight);
        if (isAble) {
            writer.write("YES");
        } else {
            writer.write("NO");
        }
        writer.flush();
    }

}
