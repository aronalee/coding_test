// prob: https://www.acmicpc.net/problem/7490

package backjoon.back7490;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class OperationCase {
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int SPACE = 2;
    private final List<Integer> operations;
    private final List<Integer> sequence;

    public OperationCase(List<Integer> operations, List<Integer> sequence) {
        this.operations = operations;
        this.sequence = sequence;
    }

    public boolean isCalculateZero() {
        List<Integer> removedSpaceOperations = operations.stream()
                .filter(operation -> operation != SPACE).collect(Collectors.toList());
        List<Integer> filteredOperations = filteringRemoveSpace();
        int sum = filteredOperations.get(0);
        for (int i = 1; i < filteredOperations.size(); i++) {
            if (removedSpaceOperations.get(i - 1) == PLUS) {
                sum += filteredOperations.get(i);
            } else if (removedSpaceOperations.get(i - 1) == MINUS) {
                sum -= filteredOperations.get(i);
            }
        }
        return sum == 0;
    }

    private List<Integer> filteringRemoveSpace() {
        List<Integer> removedSpaceSequence = new LinkedList<>();
        int number = sequence.get(0);
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i) == SPACE) {
                number = number * 10 + sequence.get(i + 1);
                continue;
            }
            removedSpaceSequence.add(number);
            number = sequence.get(i + 1);
        }
        removedSpaceSequence.add(number);
        return removedSpaceSequence;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.size(); i++) {
            sb.append(sequence.get(i));
            if (i < operations.size()) {
                if (operations.get(i) == PLUS) {
                    sb.append("+");
                } else if (operations.get(i) == MINUS) {
                    sb.append("-");
                } else if (operations.get(i) == SPACE) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}
