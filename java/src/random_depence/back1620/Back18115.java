// prob: https://github.com/tony9402/baekjoon/blob/main/picked.md

package random_depence.back1620;

import java.util.LinkedList;
import java.util.List;

public class Back18115 {

    public List<Integer> computeInitBatch(List<Integer> actions) {
        int cardNoMax = 1;
        LinkedList<Integer> initBatch = new LinkedList<>();
        for (int i = actions.size() - 1; i >= 0; i--) {
            int action = actions.get(i);
            if (action == 1) {
                initBatch.addFirst(cardNoMax);
            } else if (action == 2) {
                int tmp = initBatch.removeFirst();
                initBatch.addFirst(cardNoMax);
                initBatch.addFirst(tmp);
            } else if (action == 3) {
                initBatch.addLast(cardNoMax);
            }
            cardNoMax++;
        }
        return initBatch;
    }
}
