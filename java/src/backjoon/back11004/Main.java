// prob: https://www.acmicpc.net/problem/11004

package backjoon.back11004;

import java.io.*;
import java.util.StringTokenizer;


public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static int sortingOnce(int[] array, int left, int right) {
        if (left + 1 == right) {
            if (array[left] > array[right]) swap(array, left, right);
            return right;
        }
        int middle = (left + right) / 2;
        swap(array, left, middle);
        int pivort = array[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (j > 0 && pivort < array[j]) j--;
            while (i < array.length - 1 && pivort > array[i]) i++;
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        swap(array, left, j);
        return j;
    }

    private static void findKthNumber(int[] array, int k, int left, int right) {
        if (left < right) {
            int pivortIdx = sortingOnce(array, left, right);
            if (k < pivortIdx) {
                findKthNumber(array, k, left, pivortIdx - 1);
            } else if (k > pivortIdx) {
                findKthNumber(array, k, pivortIdx + 1, right);
            }
        }
    }

    private static int findKthNumber(int[] array, int k) {
        int left = 0;
        int right = array.length - 1;
        findKthNumber(array, k, left, right);
        return array[k];
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken()) - 1;
        int[] array = new int[n];
        String[] tokens = reader.readLine().split(" ");
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(tokens[i]);
        }
        int result = findKthNumber(array, k);
        writer.write(result + "\n");
        writer.flush();
    }
}
