// prob: https://www.acmicpc.net/problem/1092

package backjoon.back1092;

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
        // 리스트를 사용하므로 변수 n은 입력만 받고 사용하지 않는다.
        int n = Integer.parseInt(reader.readLine());
        List<Integer> cranes = new ArrayList<>();
        String[] splitLine = reader.readLine().split(" ");
        for (String crane : splitLine) {
            cranes.add(Integer.parseInt(crane));
        }
        // 리스트를 사용하므로 변수 m은 입력만 받고 사용하지 않는다.
        int m = Integer.parseInt(reader.readLine());
        List<Integer> boxes = new ArrayList<>();
        splitLine = reader.readLine().split(" ");
        for (String box : splitLine) {
            boxes.add(Integer.parseInt(box));
        }
        Back1092 back1092 = new Back1092();
        int answer = back1092.getAnswer(cranes, boxes);
        writer.write(answer + "\n");
        writer.flush();
    }
}
