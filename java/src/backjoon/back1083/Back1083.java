// prob: https://www.acmicpc.net/problem/1083

package backjoon.back1083;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Back1083 {

    public List<Integer> createAnswer(final List<Integer> numbers, int s) {
        List<Integer> bestSequence = createBestSequence(numbers);
        List<Integer> cloneSequence = new ArrayList<>(numbers);
        List<Integer> answerSequence = new LinkedList<>();
        int removeIdx = 0;
        while (s > 0) {
            if (bestSequence.size() == 0) {
                break;
            }
            for (int i = 0; i < cloneSequence.size(); i++) {
                if (cloneSequence.get(i).intValue() != bestSequence.get(removeIdx)) {
                    continue;
                }
                if (i > s) {
                    removeIdx++;
                    break;
                }
                answerSequence.add(bestSequence.remove(removeIdx));
                cloneSequence.remove(i);
                s -= i;
                removeIdx = 0;
                break;
            }
        }
        if (answerSequence.size() != numbers.size()) {
            answerSequence.addAll(cloneSequence);
        }
        return answerSequence;
    }

    private List<Integer> createBestSequence(List<Integer> numbers) {
        List<Integer> bestList = new LinkedList<>(numbers);
        Collections.sort(bestList);
        Collections.reverse(bestList);
        return bestList;
    }

}
