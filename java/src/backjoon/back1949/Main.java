// prob: https://www.acmicpc.net/problem/1949

package backjoon.back1949;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        int totalNodes = Integer.parseInt(reader.readLine());
        List<Integer> towns = new ArrayList<>();
        String[] inputs = reader.readLine().split(" ");
        for (String input : inputs) {
            towns.add(Integer.parseInt(input));
        }
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < totalNodes; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < totalNodes - 1; i++) {
            String[] edge = reader.readLine().split(" ");
            int start = Integer.parseInt(edge[0]) - 1;
            int end = Integer.parseInt(edge[1]) - 1;
            tree.get(start).add(end);
            tree.get(end).add(start);
        }
        Back1949 back1949 = new Back1949(towns, tree);
        int people = back1949.sumGoodTownPeople();
        writer.write(people + "\n");
        writer.flush();
    }
}
