// prob: https://www.acmicpc.net/problem/1535

package backjoon.back1535;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new LinkedList<>();
        String[] inputOfLostHp = reader.readLine().split(" ");
        String[] inputOfHappy = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int lostHp = Integer.parseInt(inputOfLostHp[i]);
            int happy = Integer.parseInt(inputOfHappy[i]);
            people.add(Person.of(lostHp, happy));
        }
        Back1535 back1535 = new Back1535();
        int maxHappy = back1535.findMaxHappy(people);
        writer.write(maxHappy + "\n");
        writer.flush();
    }
}
