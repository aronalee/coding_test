// prob: https://www.acmicpc.net/problem/15723

package backjoon.back15723;

import java.util.*;

public class Back15723 {
    private final Map<String, List<String>> decisions;

    public Back15723(Map<String, List<String>> decisions) {
        this.decisions = decisions;
    }

    public boolean isPossible(String src, String dst) {
        if (!decisions.containsKey(src)) {
            return false;
        }
        Set<String> isVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>(decisions.get(src));
        while (!queue.isEmpty()) {
            String now = queue.remove();
            if (now.equals(dst)) {
                return true;
            }
            if (isVisited.contains(now)) {
                continue;
            }
            isVisited.add(now);
            if (!decisions.containsKey(now)) {
                continue;
            }
            queue.addAll(decisions.get(now));
        }
        return false;
    }
}
