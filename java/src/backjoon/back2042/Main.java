// prob: https://www.acmicpc.net/problem/2042

package backjoon.back2042;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class SegmentTree {
    private final long[] tree;
    private final int leftIdxStart;

    public SegmentTree(long[] elements) {
        int height = 0;
        int length = elements.length;
        while (length != 0) {
            length /= 2;
            height++;
        }
        int treeSize = (int) Math.pow(2, height + 1);
        leftIdxStart = treeSize / 2 - 1;
        tree = new long[treeSize + 1];
        for (int i = 0; i < elements.length; i++) {
            tree[leftIdxStart + i + 1] = elements[i];
        }
        int i = treeSize - 1;
        while (i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

    public void update(int idx, long value) {
        idx += leftIdxStart;
        tree[idx] = value;
        for (int i = idx; i > 0; i /= 2) {
            if (i % 2 == 0)
                tree[i / 2] = tree[i] + tree[i + 1];
            else
                tree[i / 2] = tree[i] + tree[i - 1];
        }
    }

    public long getPrefixSum(int start, int end) {
        start += leftIdxStart;
        end += leftIdxStart;
        long sum = 0;
        while (start <= end) {
            if (start % 2 == 1) {
                sum += tree[start];
                start++;
            }
            if (end % 2 == 0) {
                sum += tree[end];
                end--;
            }
            start /= 2;
            end /= 2;
        }
        return sum;
    }
}

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] tmp = reader.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int m = Integer.parseInt(tmp[1]);
        int k = Integer.parseInt(tmp[2]);
        long[] elements = new long[n];
        for (int i = 0; i < elements.length; i++) {
            elements[i] = Long.parseLong(reader.readLine());
        }
        SegmentTree segmentTree = new SegmentTree(elements);
        List<Long> listSum = new LinkedList<>();
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
                    long result = segmentTree.getPrefixSum(start, end);
                    listSum.add(result);
                    break;
            }
        }
        for (Long sum : listSum) {
            writer.write(sum + "\n");
        }
        writer.flush();
    }
}
