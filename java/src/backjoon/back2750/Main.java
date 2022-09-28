// prob: https://www.acmicpc.net/problem/2750

package backjoon.back2750;

import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j])
                    swap(array, j - 1, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        bubbleSort(numbers);
        for (int i = 0; i < n; i++) {
            writer.write(numbers[i] + "\n");
        }
        writer.flush();
    }
}
