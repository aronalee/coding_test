// prob: https://school.programmers.co.kr/learn/courses/30/lessons/138475

package programmers.억억단을외우자;

import java.util.Arrays;

public class Solution {


    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] divisors = createDivisors(e);
        int[][] segmentTree = createSegmentTree(divisors, e);
        for (int i = 0; i < starts.length; i++) {
            int start = starts[i];
            answer[i] = getMaxFactorsNumber(start, e, segmentTree);
        }
        return answer;
    }

    private int[] createDivisors(final int end) {
        int[] divisors = new int[end + 1];
        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= end / i; j++) {
                divisors[i * j]++;
            }
        }
        return divisors;
    }

    private int[][] createSegmentTree(int[] divisors, int end) {
        int[][] tree = new int[end * 2 + 1][2];
        for (final int[] subTree : tree) {
            Arrays.fill(subTree, Integer.MIN_VALUE);
        }
        for (int i = 1; i < divisors.length; i++) {
            tree[i + end][0] = i;
            tree[i + end][1] = divisors[i];
        }
        int idx = tree.length - 1;
        while (idx != 1) {
            int parent = idx / 2;
            if (tree[parent][1] < tree[idx][1]) {
                tree[parent] = tree[idx];
            } else if (tree[parent][1] == tree[idx][1]
                && tree[parent][0] > tree[idx][0]) {
                tree[parent] = tree[idx];
            }
            idx--;
        }
        return tree;
    }

    private int getMaxFactorsNumber(final int start, final int end
        , final int[][] segmentTree) {
        int[] now = new int[2];
        int startIdx = start + segmentTree.length / 2;
        int endIdx = end + segmentTree.length / 2;
        while (startIdx <= endIdx) {
            if (startIdx % 2 == 1) {
                if (segmentTree[startIdx][1] > now[1]) {
                    now = segmentTree[startIdx];
                } else if (segmentTree[startIdx][1] == now[1]
                    && segmentTree[startIdx][0] < now[0]) {
                    now = segmentTree[startIdx];
                }
                startIdx++;
            }
            startIdx /= 2;
            if (endIdx % 2 == 0) {
                if (segmentTree[endIdx][1] > now[1]) {
                    now = segmentTree[endIdx];
                } else if (segmentTree[endIdx][1] == now[1]
                    && segmentTree[endIdx][0] < now[0]) {
                    now = segmentTree[endIdx];
                }
                endIdx--;
            }
            endIdx /= 2;
        }
        return now[0];
    }
}
