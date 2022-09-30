// prob: https://www.acmicpc.net/problem/1517

package backjoon.back1517;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long countSwap = 0;
    private static int[] array;
    private static int[] tmp;

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2;
        int leftIdx = start;
        int rightIdx = mid + 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        for (int i = start; i <= end; i++) {
            if (leftIdx <= mid && rightIdx <= end) {
                if (array[leftIdx] <= array[rightIdx]) {
                    tmp[i] = array[leftIdx];
                    leftIdx++;
                } else {
                    tmp[i] = array[rightIdx];
                    countSwap += rightIdx - i;
                    rightIdx++;
                }
            } else if (leftIdx > mid) {
                tmp[i] = array[rightIdx];
                rightIdx++;
            } else {
                tmp[i] = array[leftIdx];
                leftIdx++;
            }
        }
        if (end + 1 - start >= 0) System.arraycopy(tmp, start, array, start, end + 1 - start);
    }

    private static void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        array = new int[n];
        tmp = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
        mergeSort();
        writer.write(countSwap + "");
        writer.flush();
    }
}
