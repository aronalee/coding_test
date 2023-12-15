// prob: https://www.acmicpc.net/problem/5568

package random_depense.back5568;

import java.util.LinkedList;
import java.util.List;

public class Back5568 {

    public int createSubNumbers(List<Integer> cards, int n) {
        return (int) createPermutation(cards, n).stream()
                .distinct().count();

    }

    private List<String> createPermutation(List<Integer> cards, int n) {
        List<String> results = new LinkedList<>();
        if (n == 1) {
            for (Integer card : cards) {
                results.add(card.toString());
            }
            return results;
        }
        for (Integer card : cards) {
            List<Integer> tmp = new LinkedList<>(cards);
            tmp.remove(card);
            createPermutation(tmp, n - 1).stream()
                    .map(s -> card.toString() + s)
                    .forEach(results::add);
        }
        return results;
    }
}