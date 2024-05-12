// prob: https://www.acmicpc.net/problem/12919

package random_depnence.back12919;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back12919 {
    private static final Boolean MASK_A = Boolean.FALSE;
    private static final Boolean MASK_B = Boolean.TRUE;

    public boolean isMakeTarget(String startWord, String targetWord) {
        Queue<LinkedList<Boolean>> queue = new LinkedList<>();
        LinkedList<Boolean> startWordMask = convertStringToBoolMask(startWord);
        LinkedList<Boolean> targetWordMask = convertStringToBoolMask(targetWord);
        queue.add(targetWordMask);
        while (!queue.isEmpty()) {
            LinkedList<Boolean> now = queue.remove();
            if (now.size() == startWordMask.size()) {
                if (now.equals(startWordMask)) {
                    return true;
                }
                continue;
            }
            if (now.getLast() == MASK_A) {
                queue.add(createNextAStep(now));
            }
            if (now.getFirst() == MASK_B) {
                queue.add(createNextBStep(now));
            }
        }
        return false;
    }

    private LinkedList<Boolean> convertStringToBoolMask(String startWord) {
        LinkedList<Boolean> mask = new LinkedList<>();
        for (char c : startWord.toCharArray()) {
            if (c == 'A') {
                mask.add(MASK_A);
            } else if (c == 'B') {
                mask.add(MASK_B);
            }
        }
        return mask;
    }

    private LinkedList<Boolean> createNextAStep(LinkedList<Boolean> now) {
        LinkedList<Boolean> nextStepA = new LinkedList<>(now);
        nextStepA.removeLast();
        return nextStepA;
    }

    private LinkedList<Boolean> createNextBStep(List<Boolean> now) {
        LinkedList<Boolean> nextStepB = new LinkedList<>(now);
        Collections.reverse(nextStepB);
        nextStepB.removeLast();
        return nextStepB;
    }

}
