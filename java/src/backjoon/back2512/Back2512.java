
package backjoon.back2512;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Back2512 {

    private final List<Integer> budges;
    private final int initTotalBudge;

    public Back2512(List<Integer> budges, int initTotalBudge) {
        this.budges = budges;
        this.initTotalBudge = initTotalBudge;
    }

    public int findMaxAllocatedBudge() {
        Queue<Node> queue = new LinkedList<>();
        for (Integer budge : budges) {
            queue.add(new Node(0, budge));
        }
        int totalBudge = initTotalBudge;
        List<Node> allocatedBudge = new LinkedList<>();
        while (!queue.isEmpty()) {
            int remainRegions = queue.size();
            int avg = totalBudge / remainRegions;
            if (avg == 0) {
                allocatedBudge.addAll(queue);
                break;
            }
            for (int i = 0; i < remainRegions; i++) {
                Node now = queue.remove();
                int remainBudge = now.limitBudge - now.budge;
                if (remainBudge <= avg) {
                    totalBudge -= remainBudge;
                    now.budge += remainBudge;
                    allocatedBudge.add(now);
                    continue;
                }
                totalBudge -= avg;
                now.addBudge(avg);
                queue.add(now);
            }
        }
        return findMaxBudge(allocatedBudge);
    }

    private int findMaxBudge(List<Node> allocatedBudge) {
        int maxBudge = 0;
        for (Node node : allocatedBudge) {
            maxBudge = Math.max(maxBudge, node.budge);
        }
        return maxBudge;
    }

    private static class Node {

        private final int limitBudge;
        private int budge;

        public Node(int budge, int limitBudge) {
            this.budge = budge;
            this.limitBudge = limitBudge;
        }

        private void addBudge(final int budge) {
            this.budge += budge;
        }
    }
}
