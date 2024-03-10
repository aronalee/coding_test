// prob: https://www.acmicpc.net/problem/19699

package random_depnence.back19699;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Back19699 {
    private List<Integer> weightOfCows;

    public List<Integer> computePrimes(List<Integer> weightOfCows, int countSelectedCows) {
        this.weightOfCows = weightOfCows;
        return initCombinations(new LinkedList<>(), new LinkedList<>(), 0, countSelectedCows).stream()
                .mapToInt(combination -> combination.stream().reduce(Integer::sum).orElse(0))
                .filter(this::isPrime)
                .distinct()
                .sorted().boxed().collect(Collectors.toList());
    }

    private List<List<Integer>> initCombinations(List<List<Integer>> combinations, List<Integer> combination, int idx, int countSelectedCows) {
        if (countSelectedCows == 0) {
            combinations.add(new LinkedList<>(combination));
            return combinations;
        }
        for (int i = idx; i < weightOfCows.size(); i++) {
            combination.add(weightOfCows.get(i));
            initCombinations(combinations, combination, i + 1, countSelectedCows - 1);
            combination.remove(weightOfCows.get(i));
        }
        return combinations;
    }

    private boolean isPrime(Integer value) {
        if (value == 1) {
            return false;
        }
        if (value == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }
}
