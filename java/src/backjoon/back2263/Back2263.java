// prob: https://www.acmicpc.net/problem/2263

package backjoon.back2263;

import java.util.ArrayList;
import java.util.List;

public class Back2263 {
    private final int nodeTotal;
    private final List<Integer> sequenceInOrder;
    private final List<Integer> sequencePostOrder;


    public Back2263(int nodeTotal, List<Integer> sequenceInOrder, List<Integer> sequencePostOrder) {
        this.nodeTotal = nodeTotal;
        this.sequenceInOrder = sequenceInOrder;
        this.sequencePostOrder = sequencePostOrder;
    }

    public List<Integer> computeSequencePreOrder() {
        List<Integer> sequencePreOrder = new ArrayList<>();
        addElements(sequencePreOrder, nodeTotal);
        return sequencePreOrder;
    }

    private void addElements(List<Integer> sequencePreOrder, int nodeTotal) {
        traverseSubTrees(sequencePreOrder, new Range(0, nodeTotal - 1), new Range(0, nodeTotal - 1));
    }


    private void traverseSubTrees(List<Integer> sequencePreOrder, Range rangeInOrder, Range rangePostOrder) {
        if (rangeInOrder.start > rangeInOrder.end || rangePostOrder.start > rangePostOrder.end) {
            return;
        }
        int parent = sequencePostOrder.get(rangePostOrder.end);
        sequencePreOrder.add(parent);
        for (int parentIdx = rangeInOrder.start; parentIdx <= rangeInOrder.end; parentIdx++) {
            if (sequenceInOrder.get(parentIdx) != parent) {
                continue;
            }
            int subTreeNodeTotal = parentIdx - rangeInOrder.start - 1;
            traverseSubTrees(sequencePreOrder, new Range(rangeInOrder.start, parentIdx - 1),
                    new Range(rangePostOrder.start, rangePostOrder.start + subTreeNodeTotal));
            traverseSubTrees(sequencePreOrder, new Range(parentIdx + 1, rangeInOrder.end),
                    new Range(rangePostOrder.start + subTreeNodeTotal + 1, rangePostOrder.end - 1));
            break;
        }

    }

    private static class Range {
        private final int start;
        private final int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
