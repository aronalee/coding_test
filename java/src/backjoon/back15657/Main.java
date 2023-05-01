// prob: https://www.acmicpc.net/problem/15657

package backjoon.back15657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private static final BufferedReader reader = new BufferedReader(
        new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] splitLine = reader.readLine().split(" ");
        int n = Integer.parseInt(splitLine[0]);
        int m = Integer.parseInt(splitLine[1]);
        List<Integer> numbers = new ArrayList<>();
        splitLine = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(splitLine[i]));
        }
        // 비 내림차순 조건을 만족하기 위해 정렬
        numbers.sort(Comparator.comparingInt(o -> o));
        // 정렬후 재귀적으로 수열 탐색
        addSequenceInWriter(numbers, m, new LinkedList<>(), 0);
        writer.flush();
    }

    private static void addSequenceInWriter(List<Integer> numbers, int m,
        LinkedList<Integer> sequence, int pivort) throws IOException {
        // 수열의 숫자 개수가 n개이면 종료
        if (sequence.size() == m) {
            for (int i = 0; i < sequence.size() - 1; i++) {
                Integer number = sequence.get(i);
                writer.write(number + " ");
            }
            Integer number = sequence.get(sequence.size() - 1);
            writer.write(number + "\n");
            return;
        }
        // 수열의 숫자 개수가 n개이하이면 재귀 탐색 시작
        for (int i = pivort; i < numbers.size(); i++) {
            sequence.add(numbers.get(i));
            addSequenceInWriter(numbers, m, sequence, i);
            sequence.removeLast();
        }
    }
}
