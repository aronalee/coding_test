// prob: https://www.acmicpc.net/problem/21315

package backjoon.back21315;

import java.util.Deque;
import java.util.LinkedList;

public class Back21315 {
    private int firstK;
    private int secondK;

    public int getFirstK() {
        return firstK;
    }

    public int getSecondK() {
        return secondK;
    }

    public void simulateShuffle(int n, int[] dstCardSequence) {
        LinkedList<Integer> startCards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            startCards.addLast(i + 1);
        }
        for (int firstK = 1; Math.pow(2, firstK) < n; firstK++) {
            LinkedList<Integer> shuffledFirstK = shuffle(firstK, new LinkedList<>(startCards));
            for (int secondK = 1; Math.pow(2, secondK) < n; secondK++) {
                LinkedList<Integer> shuffleSecondK = shuffle(secondK, new LinkedList<>(shuffledFirstK));
                if (isEqualDstCardSequence(shuffleSecondK, dstCardSequence)) {
                    this.firstK = firstK;
                    this.secondK = secondK;
                    return;
                }
            }
        }
        throw new IllegalArgumentException("not founded");
    }

    private LinkedList<Integer> shuffle(int k, LinkedList<Integer> cards) {
        Deque<Integer> deque = cards;
        int count = (int) Math.pow(2, k);
        rotateDeque(count, deque);
        LinkedList<Integer> shuffledCards = new LinkedList<>();
        addShuffledCards(cards.size() - count, deque, shuffledCards);
        for (int i = 1; i <= k; i++) {
            count = (int) Math.pow(2, k - i);
            rotateDeque(count, deque);
            int willRemoveCardCount = deque.size() / 2;
            if (willRemoveCardCount > deque.size()) {
                willRemoveCardCount = deque.size();
            }
            addShuffledCards(willRemoveCardCount, deque, shuffledCards);
        }
        addShuffledCards(deque.size(), deque, shuffledCards);
        return shuffledCards;
    }

    private void rotateDeque(int countRotate, Deque<Integer> deque) {
        for (int j = 0; j < countRotate; j++) {
            deque.addFirst(deque.removeLast());
        }
    }

    private void addShuffledCards(int willRemoveCardCount, Deque<Integer> deque, LinkedList<Integer> shuffledCards) {
        for (int i = 0; i < willRemoveCardCount; i++) {
            shuffledCards.addFirst(deque.removeLast());
        }
    }

    private boolean isEqualDstCardSequence(LinkedList<Integer> shuffledCard, int[] cards) {
        int idx = 0;
        for (Integer card : shuffledCard) {
            if (card != cards[idx++]) {
                return false;
            }
        }
        return true;
    }
}
