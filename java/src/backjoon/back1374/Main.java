// prob: https://www.acmicpc.net/problem/1374

package backjoon.back1374;

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
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int startedAt = Integer.parseInt(input[1]);
            int endedAt = Integer.parseInt(input[2]);
            courses.add(Course.of(id, startedAt, endedAt));
        }
        Back1374 back1374 = new Back1374();
        int result = back1374.getMinRooms(courses);
        writer.write(result + "\n");
        writer.flush();
    }
}
