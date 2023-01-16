// prob: https://www.acmicpc.net/problem/2512

package backjoon.back2512;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        // 총 지역수를 입력받지만 배열이 아닌 리스트를 이용하기에 사용하지 않아 할당하지 않는다.
        // noinspection ResultOfMethodCallIgnored
        Integer.parseInt(reader.readLine());
        List<Integer> budges = new LinkedList<>();
        for (String splitLine : reader.readLine().split(" ")) {
            budges.add(Integer.parseInt(splitLine));
        }
        int totalBudges = Integer.parseInt(reader.readLine());
        Back2512 back2512 = new Back2512(budges, totalBudges);
        int result = back2512.findMaxAllocatedBudge();
        writer.write(result + "\n");
        writer.flush();
    }
}
