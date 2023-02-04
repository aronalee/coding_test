// prob: https://www.acmicpc.net/problem/7568

package backjoon.back7568;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] splitLine = reader.readLine().split(" ");
            int weight = Integer.parseInt(splitLine[0]);
            int height = Integer.parseInt(splitLine[1]);
            people.add(Person.of(i, weight, height));
        }
        Back7568 back7568 = new Back7568();
        List<Integer> grades = back7568.createGrades(people);
        for (Integer grade : grades) {
            writer.write(grade + " ");
        }
        writer.flush();
    }
}
