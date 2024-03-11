// prob: https://www.acmicpc.net/problem/7490

package backjoon;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Back7490 {
    private static final int[] OPERATIONS = new int[]{OperationCase.PLUS, OperationCase.MINUS, OperationCase.SPACE};

    public List<OperationCase> generateAllCases(int n) {
        List<OperationCase> cases = new LinkedList<>();
        generateAllCases(cases, new LinkedList<>(), n - 1);
        return cases.stream().filter(OperationCase::isCalculateZero).collect(Collectors.toList());
    }

    private void generateAllCases(List<OperationCase> cases, List<Integer> operations, int countOfOperations) {
        if (countOfOperations == 0) {
            cases.add(new OperationCase(new LinkedList<>(operations), createSequence(operations.size() + 1)));
            return;
        }
        for (int operation : OPERATIONS) {
            operations.add(operation);
            generateAllCases(cases, operations, countOfOperations - 1);
            operations.remove(operations.size() - 1);
        }
    }

    private List<Integer> createSequence(int size) {
        List<Integer> sequence = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            sequence.add(i + 1);
        }
        return sequence;
    }
}
