// prob: https://www.acmicpc.net/problem/13164

package backjoon;

import java.util.ArrayList;
import java.util.List;

public class Back13164 {
    public int computeMinCost(List<Integer> sequence, int teamCount) {
        List<Integer> adjMinCost = new ArrayList<>();
        for (int i = 1; i < sequence.size(); i++) {
            adjMinCost.add(sequence.get(i) - sequence.get(i - 1));
        }
        adjMinCost.sort(Integer::compareTo);
        int minCost = 0;
        for (int i = 0; i < adjMinCost.size() - teamCount + 1; i++) {
            minCost += adjMinCost.get(i);
        }
        return minCost;
    }
}
