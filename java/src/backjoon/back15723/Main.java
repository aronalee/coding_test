// prob: https://www.acmicpc.net/problem/15723

package backjoon.back15723;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int countDecisions = Integer.parseInt(reader.readLine());
        Map<String, List<String>> decisions = inputPropositions(countDecisions);
        int countQuestions = Integer.parseInt(reader.readLine());
        List<List<String>> questions = inputQuestions(countQuestions);
        Back15723 back15723 = new Back15723(decisions);
        for (List<String> question : questions) {
            if (back15723.isPossible(question.get(0), question.get(1))) {
                writer.write("T\n");
                continue;
            }
            writer.write("F\n");
        }
        writer.flush();
    }

    private static List<List<String>> inputQuestions(int countQuestions) throws IOException {
        List<List<String>> questions = new LinkedList<>();
        for (int i = 0; i < countQuestions; i++) {
            String[] question = reader.readLine().split(" ");
            questions.add(List.of(question[0], question[2]));
        }
        return questions;
    }

    private static Map<String, List<String>> inputPropositions(int countDecisions) throws IOException {
        Map<String, List<String>> decisions = new HashMap<>();
        for (int i = 0; i < countDecisions; i++) {
            String[] decision = reader.readLine().split(" ");
            decisions.putIfAbsent(decision[0], new LinkedList<>());
            decisions.computeIfPresent(decision[0], (k, v) -> {
                v.add(decision[2]);
                return v;
            });
        }
        return decisions;
    }

}
