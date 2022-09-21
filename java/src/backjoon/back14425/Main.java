// prob:https://www.acmicpc.net/problem/14425

package backjoon.back14425;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] line = reader.readLine().split(" ");
        Set<String> set = new HashSet<>();
        int hit = 0;
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            set.add(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            hit += set.contains(reader.readLine()) ? 1 : 0;
        }
        writer.write(String.format("%d",hit));
        writer.flush();
    }
}
