// prob: https://www.acmicpc.net/problem/2751

package backjoon.back2751;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] tmp;
    private static int[] array;

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = (start + end) / 2;
        int leftIdx = start;
        int rightIdx = mid + 1;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);
        if (end + 1 - start >= 0) System.arraycopy(array, start, tmp, start, end + 1 - start);
        for (int sortedArrIdx = start; sortedArrIdx <= end; sortedArrIdx++) {
            if (leftIdx <= mid && rightIdx <= end) {
                if (tmp[leftIdx] < tmp[rightIdx]) {
                    array[sortedArrIdx] = tmp[leftIdx];
                    leftIdx++;
                } else {
                    array[sortedArrIdx] = tmp[rightIdx];
                    rightIdx++;
                }
            } else if (leftIdx > mid) {
                array[sortedArrIdx] = tmp[rightIdx];
                rightIdx++;
            } else {
                array[sortedArrIdx] = tmp[leftIdx];
                leftIdx++;
            }
        }
    }

    private static void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        array = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        mergeSort();
        for (int i : array) {
            writer.write(i + "\n");
        }
        writer.flush();
        writer.close();
    }
}
