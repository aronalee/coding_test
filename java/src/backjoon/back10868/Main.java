// prob: https://www.acmicpc.net/problem/10868

package backjoon.back10868;

import java.io.*;
import java.util.Arrays;

class SegmentTree<T> {
    private final int[] trees;
    private final int startLeftIdx;

    public SegmentTree(int[] elements) {
        int treeSize = 2;
        while (treeSize <= elements.length) {
            treeSize *= 2;
        }
        treeSize *= 2;
        trees = new int[treeSize + 1];
        Arrays.fill(trees, Integer.MAX_VALUE);
        startLeftIdx = treeSize / 2 - 1;
        for (int i = 0; i < elements.length; i++) {
            update(i + 1, elements[i]);
        }
    }

    public void update(int idx, int value) {
        idx += startLeftIdx;
        trees[idx] = value;
        for (int i = idx; i > 0; i /= 2) {
            if (i % 2 == 0)
                trees[i / 2] = Math.min(trees[i], trees[i + 1]);
            else
                trees[i / 2] = Math.min(trees[i], trees[i - 1]);
        }
    }

    public int getPrefixMinValue(int start, int end) {
        start += startLeftIdx;
        end += startLeftIdx;
        int minValue = Integer.MAX_VALUE;
        while (start <= end) {
            if (start % 2 == 1) {
                minValue = Math.min(minValue, trees[start]);
                start++;
            }
            if (end % 2 == 0) {
                minValue = Math.min(minValue, trees[end]);
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return minValue;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String[] tmp = reader.readLine().split(" ");
            int n = Integer.parseInt(tmp[0]);
            int m = Integer.parseInt(tmp[1]);
            int[] elements = new int[n];
            for (int i = 0; i < n; i++) {
                elements[i] = Integer.parseInt(reader.readLine());
            }
            SegmentTree<Integer> segmentTree = new SegmentTree<>(elements);
            for (int i = 0; i < m; i++) {
                tmp = reader.readLine().split(" ");
                int start = Integer.parseInt(tmp[0]);
                int end = Integer.parseInt(tmp[1]);
                int result = segmentTree.getPrefixMinValue(start, end);
                writer.write(result + "\n");
            }
            writer.flush();
        }
    }
}
