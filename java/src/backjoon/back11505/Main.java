// prob: https://www.acmicpc.net/problem/11505
package backjoon.back11505;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class SegmentTree {
    private final long[] trees;
    private final int leftIdxStart;
    private final long MAX_VALUE = 1_000_000_007;

    public SegmentTree(long[] elements) {
        int height = 0;
        int elementLenght = elements.length;
        while (elementLenght > 0) {
            elementLenght /= 2;
            height++;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        trees = new long[treeSize];
        Arrays.fill(trees, 1);
        leftIdxStart = treeSize / 2 - 1;
        for (int i = 0; i < elements.length; i++) {
            update(i + 1, elements[i]);
        }
    }

    public void update(int idx, long value) {
        idx += leftIdxStart;
        trees[idx] = value;
        while (idx > 0) {
            if (idx % 2 == 0) {
                trees[idx / 2] = trees[idx] * trees[idx + 1] % MAX_VALUE;
            } else {
                trees[idx / 2] = trees[idx] * trees[idx - 1] % MAX_VALUE;
            }
            idx /= 2;
        }
    }

    public long getPrefixMultiple(int start, int end) {
        start += leftIdxStart;
        end += leftIdxStart;
        long result = 1;
        while (start <= end) {
            if (start % 2 == 1) {
                result = result * trees[start] % MAX_VALUE;
                start++;
            }
            if (end % 2 == 0) {
                result = result * trees[end] % MAX_VALUE;
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return result;
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
            int k = Integer.parseInt(tmp[2]);
            long[] elements = new long[n];
            for (int i = 0; i < n; i++) {
                elements[i] = Long.parseLong(reader.readLine());
            }
            SegmentTree segmentTree = new SegmentTree(elements);
            List<Long> results = new LinkedList<>();
            for (int i = 0; i < m + k; i++) {
                tmp = reader.readLine().split(" ");
                switch (Integer.parseInt(tmp[0])) {
                    case 1:
                        int idx = Integer.parseInt(tmp[1]);
                        long value = Long.parseLong(tmp[2]);
                        segmentTree.update(idx, value);
                        break;
                    case 2:
                        int start = Integer.parseInt(tmp[1]);
                        int end = Integer.parseInt(tmp[2]);
                        long result = segmentTree.getPrefixMultiple(start, end);
                        results.add(result);
                }
            }
            for (Long result : results) {
                writer.write(result + "\n");
            }
            writer.flush();
        }
    }
}
